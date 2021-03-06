package com.avatech.edi.administrative.schedule;

import com.avatech.edi.administrative.config.HttpRequest;
import com.avatech.edi.administrative.data.OpType;
import com.avatech.edi.administrative.model.bo.CashFlow;
import com.avatech.edi.administrative.model.bo.TaskRecord;
import com.avatech.edi.administrative.model.config.MasterDataType;
import com.avatech.edi.administrative.model.dto.Response;
import com.avatech.edi.administrative.service.CashFlowService;
import com.avatech.edi.administrative.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class CashFlowJob {
    private Logger logger = LoggerFactory.getLogger(CashFlowJob.class);

    @Autowired
    private CashFlowService cashFlowService;

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
        try
        {
            List<TaskRecord> taskRecords = taskService.fetchTaskList(MasterDataType.CASHFLOW, opType);
            if (taskRecords.size() == 0)
                return;
            logger.info(">>>>>>>>>>>>>>获取未同步现金流主数据{" + taskRecords.size() + "}条");
            List<CashFlow> cashFlows = cashFlowService.fetchCashFlowByTask(taskRecords);
            logger.info(">>>>>>>>>>>>>>同步现金流主数据:" + cashFlows.toString());
            RestTemplate template = new RestTemplate();
            ResponseEntity<String> rt = template.postForEntity(request.getRequestUrl(MasterDataType.CASHFLOW, opType), cashFlows, String.class);
            ResponseEntity<Response> result = template.postForEntity(request.getRequestUrl(MasterDataType.CASHFLOW, opType), cashFlows, Response.class);
            if (result.hasBody()) {
                Response res = result.getBody();
                taskService.updateTask(TaskRecord.getTaskResult(taskRecords,res));
                logger.info(">>>>>>>>>>>>>>同步现金流主数据结果：" + res.toString());
            } else {
                taskService.updateTask(taskRecords,false,result.getBody().toString());
                logger.error(">>>>>>>>>>>>>>同步现金流主数据异常：" + result.getStatusCode() + result.getBody());
            }
        }catch (Exception e){
            logger.error(">>>>>>>>>>>>>>同步现金流主数据异常：",e);
        }
    }
}
