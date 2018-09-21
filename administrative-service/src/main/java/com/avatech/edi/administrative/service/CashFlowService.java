package com.avatech.edi.administrative.service;

import com.avatech.edi.administrative.model.bo.*;
import com.avatech.edi.administrative.model.config.MasterDataType;
import com.avatech.edi.administrative.repository.ICashFlowRepositoty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 2018/9/14.
 */
public class CashFlowService {
    private final Logger logger = LoggerFactory.getLogger(ProjectService.class);

    @Autowired
    private ICashFlowRepositoty projectRepository;

    @Autowired
    private TaskService taskService;

    public List<CashFlow> fetchUnSyncCashFlow(){
        List<TaskRecord> taskRecords = taskService.fetchTaskList(MasterDataType.CASHFLOW);
        if(taskRecords.size() == 0)
            return null;
        List<CashFlow> cashFlows = new ArrayList<>();
        CashFlow cashFlow;
        for (TaskRecord task:taskRecords) {
            try {
                cashFlow = projectRepository.findByKey(MasterData.getUniqueKey(task.getCompanyName(),task.getUniqueKey()));
                cashFlows.add(cashFlow);
            }catch (Exception e){
                logger.error("查找现金流错误："+e.getMessage());
            }
        }
        return cashFlows;
    }
}
