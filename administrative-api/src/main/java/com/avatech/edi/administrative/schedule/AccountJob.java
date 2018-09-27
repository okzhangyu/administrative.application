package com.avatech.edi.administrative.schedule;

import com.avatech.edi.administrative.config.HttpRequest;
import com.avatech.edi.administrative.data.OpType;
import com.avatech.edi.administrative.model.bo.Account;
import com.avatech.edi.administrative.model.bo.TaskRecord;
import com.avatech.edi.administrative.model.config.MasterDataType;
import com.avatech.edi.administrative.model.dto.Response;
import com.avatech.edi.administrative.service.AccountService;
import com.avatech.edi.administrative.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;


public class AccountJob {

    private Logger logger = LoggerFactory.getLogger(AccountJob.class);

    @Autowired
    private TaskService taskService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private  HttpRequest request;

    @Scheduled(cron="0 0/1 * * * ?")
    private void process() {
        processData(OpType.UPDATE);
        processData(OpType.ADD);
    }

    private void processData(String opType) {
        try
        {
            List<TaskRecord> taskRecords = taskService.fetchTaskList(MasterDataType.ACCOUNT, opType);
            if (taskRecords.size() == 0)
                return;
            logger.info(">>>>>>>>>>>>>>获取未同步科目主数据{" + taskRecords.size() + "}条");
            List<Account> accountList = accountService.fetchAccountByTask(taskRecords);
            RestTemplate template = new RestTemplate();
            logger.info(">>>>>>>>>>>>>>同步科目主数据:" + accountList.toString());
            ResponseEntity<Response> result = template.postForEntity(request.getRequestUrl(MasterDataType.ACCOUNT, opType), accountList, Response.class);
            if (result.hasBody()) {
                Response res = result.getBody();
                taskService.updateTask(taskRecords, res.getCode().equals("0") ? true : false, res.getMessage());
                logger.info(">>>>>>>>>>>>>>同步科目主数据结果：" + res.toString());
            } else {
                taskService.updateTask(taskRecords,false,result.getBody().toString());
                logger.error(">>>>>>>>>>>>>>同步科目主数据异常：" + result.getStatusCode() + result.getBody());
            }
        }catch (Exception e){
            logger.error(">>>>>>>>>>>>>>同步科目主数据异常：",e);
        }
    }

}
