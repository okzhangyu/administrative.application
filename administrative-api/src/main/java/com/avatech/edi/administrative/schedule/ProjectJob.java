package com.avatech.edi.administrative.schedule;

import com.avatech.edi.administrative.model.bo.Project;
import com.avatech.edi.administrative.service.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

/**
 * 项目
 */
public class ProjectJob {
    private Logger logger = LoggerFactory.getLogger(CostCenterJob.class);

    @Autowired
    private ProjectService projectService;

    @Scheduled(cron="0 0/1 * * * ?")
    private void process() {
        List<Project> projects = projectService.fetchUnSyncProject();
        if (projects == null || projects.size() == 0) {
            return;
        }
        logger.info(">>>>>>>>>>>>>>获取未同步项目主数据{" + projects.size() + "}条");
        // TODO call OA service

        // TODO update taskrecord

    }
}
