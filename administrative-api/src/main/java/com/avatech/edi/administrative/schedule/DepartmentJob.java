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
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeType;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @Scheduled(cron = "0 0/5 * * * ?")
    private void process() throws Exception {
        processData(OpType.ADD);
        processData(OpType.UPDATE);
        processData(OpType.DELETE);
    }

    private void processData(String opType) throws Exception{
        try {
            List<TaskRecord> taskRecords = taskService.fetchTaskList(MasterDataType.DEPARTMENT, opType);
            if (taskRecords.size() == 0)
                return;
            logger.info(">>>>>>>>>>>>>>获取未同步部门主数据{" + taskRecords.size() + "}条");
            Department department;
            RestTemplate template = new RestTemplate();
            ResponseEntity<String> result = null;
            for (TaskRecord record : taskRecords) {
                department = departmentService.fetchDepartment(record);
                if (department==null){
                    throw new Exception("部门主数据为空");
                }
                if (record == null) {
                    record.setIsSync("E");
                    record.setSyncMessage(" 未找到部门信息");
                    taskService.updateTask(record);
                    continue;
                }
                if (OpType.ADD.equals(opType)) {
                    result = template.postForEntity(request.getRequestUrl(MasterDataType.DEPARTMENT, opType), department, String.class);
                } else {
                    HttpHeaders headers = new HttpHeaders();
                    MimeType mimeType = MimeTypeUtils.parseMimeType("application/json");
                    MediaType mediaType = new MediaType(mimeType.getType(), mimeType.getSubtype(), Charset.forName("UTF-8"));
                    headers.setContentType(mediaType);
                    if (OpType.UPDATE.equals(opType)) {
                        HttpEntity<Map> entity = new HttpEntity<Map>(Department.createUpdateMap(department), headers);
                        result = template.exchange(request.getRequestUrl(MasterDataType.DEPARTMENT, opType), HttpMethod.PUT, entity, String.class);
                    } else if (OpType.DELETE.equals(opType)) {
                        result = template.exchange(request.getDeleteUrl(MasterDataType.DEPARTMENT, department.getCode()), HttpMethod.PUT, null, String.class);
                    }
                }
                if (result.hasBody()) {
                    OrgResponse res = (OrgResponse) mapper.readValue(result.getBody(), OrgResponse.class);


                    if(res == null){
                        record.setIsSync("E");
                        record.setSyncMessage("同步失败，返回结果为空");
                    }else {
                        if( res.getSuccess()){
                            record.setIsSync("Y");
                            record.setSyncMessage("Successful");
                        }else {
                            record.setIsSync("E");
                            record.setSyncMessage(res.getErrorMsgs().get(0).getCode());
                        }
                    }
                    taskService.updateTask(record);
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

