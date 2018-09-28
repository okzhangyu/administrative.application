package com.avatech.edi.administrative.schedule;

import com.avatech.edi.administrative.config.HttpRequest;
import com.avatech.edi.administrative.data.OpType;
import com.avatech.edi.administrative.model.bo.Company;
import com.avatech.edi.administrative.model.bo.Department;
import com.avatech.edi.administrative.model.bo.TaskRecord;
import com.avatech.edi.administrative.model.config.MasterDataType;
import com.avatech.edi.administrative.model.dto.OrgResponse;
import com.avatech.edi.administrative.model.dto.Response;
import com.avatech.edi.administrative.service.DepartmentService;
import com.avatech.edi.administrative.service.TaskService;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class DepartmentJob {

    private final Logger logger = LoggerFactory.getLogger(DepartmentJob.class);

    @Autowired
    private DepartmentService departmentService;

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

    private void processData(String opType){
        try {
            List<TaskRecord> taskRecords = taskService.fetchTaskList(MasterDataType.DEPARTMENT, opType);
            if (taskRecords.size() == 0)
                return;
            logger.info(">>>>>>>>>>>>>>获取未同步部门主数据{" + taskRecords.size() + "}条");
            List<Department> departments = departmentService.fetchDepartments(taskRecords);
            logger.info(">>>>>>>>>>>>>>同步部门主数据:" + departments.toString());
            RestTemplate template = new RestTemplate();
            for (Department department:departments) {
                ResponseEntity<String> result = template.postForEntity(request.getRequestUrl(MasterDataType.DEPARTMENT, opType), department, String.class);
                if (result.hasBody()) {
                    OrgResponse res = (OrgResponse) mapper.readValue(result.getBody(), OrgResponse.class);
                    taskService.updateTask(taskRecords, res.getSuccess(), res.getSuccess()?"Successful":"Failed");
                    logger.info(">>>>>>>>>>>>>>同步部门主数据结果：" + result.toString());
                } else {
                    taskService.updateTask(taskRecords, false, result.getBody().toString());
                    logger.error(">>>>>>>>>>>>>>同步部门主数据异常：" + result.getStatusCode() + result.getBody());
                }
            }

        } catch (Exception e) {
            logger.error(">>>>>>>>>>>>>>同步部门主数据异常：", e);
        }
    }


}

