package com.avatech.edi.administrative.service;

import com.avatech.common.edi.administrative.common.exception.BusinessException;
import com.avatech.edi.administrative.model.bo.TaskRecord;
import com.avatech.edi.administrative.repository.ITaskRepository;
import javafx.concurrent.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private ITaskRepository taskRepository;

    public List<TaskRecord> fetchTaskList(String objectCode){
        return taskRepository.findByObjectCodeAndIsSync(objectCode,"N");
    }

    public List<TaskRecord> fetchTaskList(String objectCode,String opType){
        return taskRepository.findByObjectCodeAndIsSyncAndOpType(objectCode,"N",opType);
    }


    public void updateTask(List<TaskRecord> taskRecords,boolean isSync,String message){
        String isSyncValue = null;
        if(isSync){
            isSyncValue = "Y" ;
        }else {
            isSyncValue = "E";
        }
        for (TaskRecord task:taskRecords) {
            task.setIsSync(isSyncValue);
            task.setSyncMessage(message);
        }
        taskRepository.saveAll(taskRecords);
    }

    public void updateTask(TaskRecord taskRecord){
        taskRepository.save(taskRecord);
    }

    public void updateTask(List<TaskRecord> taskRecords){
        if(taskRecords.size() > 0)
            taskRepository.saveAll(taskRecords);
        else
            throw new BusinessException("中间表记录为空");
    }

    private List<Integer> getTaskIds(List<TaskRecord> taskRecords){
        List<Integer> docEntrys = new ArrayList<>();
        for (TaskRecord task:taskRecords) {
            docEntrys.add(task.getDocEntry());
        }
        return docEntrys;
    }
}
