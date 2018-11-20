package com.avatech.edi.administrative.service;

import com.avatech.edi.administrative.model.bo.*;
import com.avatech.edi.administrative.model.config.MasterDataType;
import com.avatech.edi.administrative.model.dto.Response;
import com.avatech.edi.administrative.repository.ICashFlowRepositoty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 2018/9/14.
 */
@Service
public class CashFlowService {
    private final Logger logger = LoggerFactory.getLogger(ProjectService.class);

    @Autowired
    private ICashFlowRepositoty cashFlowRepositoty;

    @Autowired
    private TaskService taskService;

//    public List<CashFlow> fetchUnSyncCashFlow(){
//        List<TaskRecord> taskRecords = taskService.fetchTaskList(MasterDataType.CASHFLOW);
//        if(taskRecords.size() == 0)
//            return null;
//       return fetchCashFlowByTask(taskRecords);
//
//    }

    public List<CashFlow> fetchCashFlowByTask(List<TaskRecord> taskRecords) {
        List<CashFlow> cashFlows = new ArrayList<>();
        CashFlow cashFlow;
        for (TaskRecord task : taskRecords) {
            try {
                cashFlow = cashFlowRepositoty.findByKey(MasterData.getUniqueKey(task.getCompanyName(), task.getUniqueKey()));
                if(cashFlow != null)
                    cashFlows.add(cashFlow);
            } catch (Exception e) {
                logger.error("查找现金流错误：" + e.getMessage());
            }
        }
        return cashFlows;
    }
}
