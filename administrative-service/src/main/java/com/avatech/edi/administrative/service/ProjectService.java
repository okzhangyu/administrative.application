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

    public List<Project> fetchUnSyncProject()throws Exception{
        List<TaskRecord> taskRecords = taskService.fetchTaskList(MasterDataType.PROJECT);
        if(taskRecords.size() == 0)
            return null;
        return fetchProjectByTask(taskRecords);
    }

    public List<Project> fetchProjectByTask(List<TaskRecord> taskRecords)throws Exception {
        List<Project>projects = new ArrayList<>();
        List<Project> projectlist=new ArrayList<>();
        for (TaskRecord task : taskRecords) {
            try {
                projects = projectRepository.findByKey(MasterData.getUniqueKey(task.getCompanyName(), task.getUniqueKey()));
                if (projects.size()==0){
                    logger.error("查找项目错误:" +"项目主数据"+ task.getCompanyName()+"公司中"+task.getUniqueKey()+"为空");
                }
                projectlist.addAll(projects);
            } catch (Exception e) {
                logger.error("查找项目错误：" + e.getMessage());
            }
            if (projectlist.size()==0){
                throw new Exception("项目主数据为空");
            }
        }
        return projectlist;
    }

}
