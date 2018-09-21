package com.avatech.edi.administrative.service;

import com.avatech.edi.administrative.model.bo.CashFlow;
import com.avatech.edi.administrative.model.bo.MasterData;
import com.avatech.edi.administrative.model.bo.TaskRecord;
import com.avatech.edi.administrative.model.config.MasterDataType;
import com.avatech.edi.administrative.repository.ICashFlowRepositoty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class MasterDataService {

    private final Logger logger = LoggerFactory.getLogger(ProjectService.class);

    @Autowired
    private ICashFlowRepositoty projectRepository;

    @Autowired
    private TaskService taskService;

    /**
     * 获取未同步的主数据
     * @return
     */
//    public List<CashFlow> fetchUnSyncData(String objectCode){
//        List<TaskRecord> taskRecords = taskService.fetchTaskList(objectCode);
//        if(taskRecords.size() == 0)
//            return null;
//        List<CashFlow> cashFlows = new ArrayList<>();
//        CashFlow cashFlow;
//        for (TaskRecord task:taskRecords) {
//            try {
//                cashFlow = projectRepository.findByKey(MasterData.getUniqueKey(task.getCompanyName(),task.getUniqueKey()));
//                cashFlows.add(cashFlow);
//            }catch (Exception e){
//                logger.error("查找现金流错误："+e.getMessage());
//            }
//        }
//        return cashFlows;
//    }
}
