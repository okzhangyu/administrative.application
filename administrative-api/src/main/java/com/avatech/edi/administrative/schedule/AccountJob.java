package com.avatech.edi.administrative.schedule;

import com.avatech.edi.administrative.model.bo.Account;
import com.avatech.edi.administrative.service.AccountService;
import com.avatech.edi.administrative.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountJob {

    private Logger logger = LoggerFactory.getLogger(AccountJob.class);

    @Autowired
    private AccountService accountService;

    @Scheduled(cron="0 0/1 * * * ?")
    private void process() {
        List<Account> accountList = accountService.fetchUnSyncAccount();
        if (accountList == null || accountList.size() == 0) {
            return;
        }

        logger.info(">>>>>>>>>>>>>>获取未同步科目主数据{" + accountList.size() + "}条");


    }
}
