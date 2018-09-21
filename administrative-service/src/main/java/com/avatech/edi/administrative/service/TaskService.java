package com.avatech.edi.administrative.service;

import com.avatech.edi.administrative.model.bo.TaskRecord;
import com.avatech.edi.administrative.repository.ITaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private ITaskRepository taskRepository;

    public List<TaskRecord> fetchTaskList(String objectCode){
        return taskRepository.findByObjectCodeAndIsSync(objectCode,"N");
    }
}
