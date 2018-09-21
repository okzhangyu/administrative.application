package com.avatech.edi.administrative.schedule;

import com.avatech.edi.administrative.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountJob {

    @Autowired
    private TaskService taskService;

    private void process(){

    }
}
