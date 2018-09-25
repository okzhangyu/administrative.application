package com.avatech.edi.administrative.schedule;

import com.avatech.edi.administrative.model.bo.CashFlow;
import com.avatech.edi.administrative.model.bo.CostCenter;
import com.avatech.edi.administrative.service.CashFlowService;
import com.avatech.edi.administrative.service.CostCenterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 成本中心
 */
@Component
public class CostCenterJob {

    private Logger logger = LoggerFactory.getLogger(CostCenterJob.class);

    @Autowired
    private CostCenterService costCenterService;

    @Scheduled(cron="0 0/1 * * * ?")
    private void process() {
        List<CostCenter> costCenters = costCenterService.fetchUnSyncCostCenter();
        if (costCenters == null || costCenters.size() == 0) {
            return;
        }
        logger.info(">>>>>>>>>>>>>>获取未同步成本中心主数据{" + costCenters.size() + "}条");


    }
}
