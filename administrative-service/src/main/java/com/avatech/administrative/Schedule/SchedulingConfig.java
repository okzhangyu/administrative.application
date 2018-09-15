package com.avatech.administrative.Schedule;

import com.avatech.administrative.model.bo.Project;
import com.avatech.administrative.service.IProjectService;
import com.avatech.common.data.PromptMessage;
import com.avatech.common.data.Result;
import com.avatech.common.data.ResultCode;
import com.avatech.common.data.ResultDescription;
import com.avatech.common.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

/**
 * Created by asus on 2018/9/14.
 */

@Slf4j
@Configuration
@EnableScheduling
public class SchedulingConfig {


    @Autowired
    private IProjectService projectService;

    @Scheduled(cron = "0/30 * * * * ?")
    public Result<Project> getProjects() {
        Result result = new Result();
        try {
            List<Project> projects = projectService.fetchProjects();
            result = new Result(ResultCode.SUCCESS, ResultDescription.SUCCESS, projects);
            log.info("找到了！！！！！每隔30秒执行一次");
        } catch (BusinessException e) {
            log.error(PromptMessage.PROMPT_VOUCHER_ERROR + e.getMessage());
            result = new Result(e);
        } catch (Exception e) {
            log.error(PromptMessage.PROMPT_VOUCHER_ERROR + e.getMessage());
            result = new Result(e);
        }
        return result;

    }
}
