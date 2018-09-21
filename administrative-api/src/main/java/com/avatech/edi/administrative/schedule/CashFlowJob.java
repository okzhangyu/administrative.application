package com.avatech.edi.administrative.schedule;

import com.avatech.edi.administrative.model.bo.Account;
import com.avatech.edi.administrative.model.bo.CashFlow;
import com.avatech.edi.administrative.service.AccountService;
import com.avatech.edi.administrative.service.CashFlowService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CashFlowJob {
    private Logger logger = LoggerFactory.getLogger(CashFlowJob.class);

    @Autowired
    private CashFlowService cashFlowService;

    @Scheduled(cron="0 0/1 * * * ?")
    private void process() {
        List<CashFlow> cashFlows = cashFlowService.fetchUnSyncCashFlow();
        if (cashFlows == null || cashFlows.size() == 0) {
            return;
        }
        logger.info(">>>>>>>>>>>>>>获取未同步现金流主数据{" + cashFlows.size() + "}条");


    }
}
