package com.avatech.edi.administrative.schedule;

import com.avatech.edi.administrative.config.HttpRequest;
import com.avatech.edi.administrative.data.OpType;
import com.avatech.edi.administrative.model.bo.Employee;
import com.avatech.edi.administrative.model.bo.TaskRecord;
import com.avatech.edi.administrative.model.config.MasterDataType;
import com.avatech.edi.administrative.model.dto.DefaultValue;
import com.avatech.edi.administrative.model.dto.OrgResponse;
import com.avatech.edi.administrative.service.EmployeeService;
import com.avatech.edi.administrative.service.TaskService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Component
public class EmployeeJob {

    private final Logger logger = LoggerFactory.getLogger(EmployeeJob.class);

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private HttpRequest request;

    @Autowired
    public ObjectMapper mapper ;

    @Scheduled(cron = "0 0/1 * * * ?")
    private void process(){
        processData(OpType.ADD);
    }

    private void processData(String opType) {
        try {
            List<TaskRecord> taskRecords = taskService.fetchTaskList(MasterDataType.EMPLOYEE, opType);
            if (taskRecords.size() == 0)
                return;
            logger.info(">>>>>>>>>>>>>>获取未同步员工主数据{" + taskRecords.size() + "}条");
            List<Employee> employees = employeeService.fetchEmployees(taskRecords);
            logger.info(">>>>>>>>>>>>>>同步员工主数据:" + employees.toString());
            RestTemplate template = new RestTemplate();
            for (Employee employee:employees) {
                try{
                    // get department id by department code
                    ResponseEntity<String> resDept = template.getForEntity(request.getOrgUrl(MasterDataType.DEPARTMENT, employee.getDepartCode()), String.class);
                    if(resDept.hasBody()){
                        List<DefaultValue> defaultValues = mapper.readValue(resDept.getBody(), new TypeReference<List<DefaultValue>>() {});
                        if(defaultValues.size() == 0) {
                            logger.error(">>>>>>>>>>>>>>同步员工主数据失败：根据员工部门code在OA未找到匹配的部门");
                            return;
                        }
                        employee.setOrgDepartmentId(defaultValues.get(0).getId());
                    }
                    // call oa service push employee
                    Map emMap = Employee.createEmpMap(employee);
                    String jsonResult = mapper.writerWithDefaultPrettyPrinter()
                            .writeValueAsString(emMap);
                    ResponseEntity<String> result = template.postForEntity(request.getRequestUrl(MasterDataType.EMPLOYEE, opType), emMap, String.class);
                    if (result.hasBody()) {
                        OrgResponse res = (OrgResponse) mapper.readValue(result.getBody(), OrgResponse.class);
                        taskService.updateTask(taskRecords, res.getSuccess(), res.getSuccess()?"Successful":"Failed");
                        logger.info(">>>>>>>>>>>>>>同步员工主数据结果：" + result.toString());
                    } else {
                        taskService.updateTask(taskRecords, false, result.getBody().toString());
                        logger.error(">>>>>>>>>>>>>>同步员工主数据异常：" + result.getStatusCode() + result.getBody());
                    }
                }catch (Exception e) {
                    logger.error(">>>>>>>>>>>>>>同步员工主数据" + employee.getCode() + "异常：", e);
                }
            }
        } catch (Exception e) {
            logger.error(">>>>>>>>>>>>>>同步员工主数据异常：", e);
        }
    }

}
