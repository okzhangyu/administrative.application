package com.avatech.edi.administrative.service;


import com.avatech.edi.administrative.model.bo.MasterData;
import com.avatech.edi.administrative.model.bo.Project;
import com.avatech.edi.administrative.model.bo.TaskRecord;
import com.avatech.edi.administrative.model.config.MasterDataType;
import com.avatech.edi.administrative.repository.IProjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 2018/9/13.
 */


@Service
public class ProjectService {

    private final Logger logger = LoggerFactory.getLogger(ProjectService.class);

    @Autowired
    private IProjectRepository projectRepository;

    @Autowired
    private TaskService taskService;

    public List<Project> fetchUnSyncProject(){
        List<TaskRecord> taskRecords = taskService.fetchTaskList(MasterDataType.PROJECT);
        if(taskRecords.size() == 0)
            return null;
        return fetchProjectByTask(taskRecords);
    }

    public List<Project> fetchProjectByTask(List<TaskRecord> taskRecords) {
        List<Project> projects = new ArrayList<>();
        Project project;
        for (TaskRecord task : taskRecords) {
            try {
                project = projectRepository.findByKey(MasterData.getUniqueKey(task.getCompanyName(), task.getUniqueKey()));
                projects.add(project);
            } catch (Exception e) {
                logger.error("查找项目错误：" + e.getMessage());
            }
        }
        return projects;
    }
}
