package com.avatech.edi.administrative.service;

import com.avatech.edi.administrative.model.bo.CostCenter;
import com.avatech.edi.administrative.model.bo.MasterData;
import com.avatech.edi.administrative.model.bo.TaskRecord;
import com.avatech.edi.administrative.model.config.MasterDataType;
import com.avatech.edi.administrative.repository.ICostCenterRepository;
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
public class CostCenterService {
    private final Logger logger = LoggerFactory.getLogger(ProjectService.class);

    @Autowired
    private ICostCenterRepository projectRepository;

    @Autowired
    private TaskService taskService;

    public List<CostCenter> fetchUnSyncCostCenter(){
        List<TaskRecord> taskRecords = taskService.fetchTaskList(MasterDataType.CASHFLOW);
        if(taskRecords.size() == 0)
            return null;
        List<CostCenter> costCenters = new ArrayList<>();
        CostCenter costCenter;
        for (TaskRecord task:taskRecords) {
            try {
                costCenter = projectRepository.findByKey(MasterData.getUniqueKey(task.getCompanyName(),task.getUniqueKey()));
                costCenters.add(costCenter);
            }catch (Exception e){
                logger.error("查找成本中心错误："+e.getMessage());
            }
        }
        return costCenters;
    }
}
