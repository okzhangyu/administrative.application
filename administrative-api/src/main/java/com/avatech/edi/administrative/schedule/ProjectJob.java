package com.avatech.edi.administrative.schedule;

import com.avatech.edi.administrative.config.HttpRequest;
import com.avatech.edi.administrative.data.OpType;
import com.avatech.edi.administrative.model.bo.Project;
import com.avatech.edi.administrative.model.bo.TaskRecord;
import com.avatech.edi.administrative.model.config.MasterDataType;
import com.avatech.edi.administrative.model.dto.Response;
import com.avatech.edi.administrative.service.ProjectService;
import com.avatech.edi.administrative.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 项目
 */

public class ProjectJob {
    private Logger logger = LoggerFactory.getLogger(CostCenterJob.class);

    @Autowired
    private ProjectService projectService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private HttpRequest request;

    @Scheduled(cron="0 0/1 * * * ?")
    private void process() {
        processData(OpType.ADD);
        processData(OpType.UPDATE);
    }

    private void processData(String opType) {

        try {
            List<TaskRecord> taskRecords = taskService.fetchTaskList(MasterDataType.PROJECT, opType);
            if (taskRecords.size() == 0)
                return;
            logger.info(">>>>>>>>>>>>>>获取未同步项目主数据{" + taskRecords.size() + "}条");
            List<Project> projects = projectService.fetchProjectByTask(taskRecords);
            logger.info(">>>>>>>>>>>>>>同步项目主数据:" + projects.toString());
            RestTemplate template = new RestTemplate();
            ResponseEntity<Response> result = template.postForEntity(request.getRequestUrl(MasterDataType.PROJECT, opType), projects, Response.class);
            if (result.hasBody()) {
                Response res = result.getBody();
                taskService.updateTask(taskRecords, res.getCode().equals("0") ? true : false, res.getMessage());
                logger.info(">>>>>>>>>>>>>>同步项目主数据结果：" + res.toString());
            } else {
                taskService.updateTask(taskRecords, false, result.getBody().toString());
                logger.error(">>>>>>>>>>>>>>同步项目主数据异常：" + result.getStatusCode() + result.getBody());
            }
        } catch (Exception e) {
            logger.error(">>>>>>>>>>>>>>同步项目主数据异常：", e);
        }
    }
}
