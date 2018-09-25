package com.avatech.edi.administrative.service;

import com.avatech.edi.administrative.model.bo.TaskRecord;
import com.avatech.edi.administrative.repository.ITaskRepository;
import javafx.concurrent.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        taskRepository.updateTask(getTaskIds(taskRecords),isSync == true?"Y":"N",message);
    }

    private List<Integer> getTaskIds(List<TaskRecord> taskRecords){
        List<Integer> docEntrys = new ArrayList<>();
        for (TaskRecord task:taskRecords) {
            docEntrys.add(task.getDocEntry());
        }
        return docEntrys;
    }
}
