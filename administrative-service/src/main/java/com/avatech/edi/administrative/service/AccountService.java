package com.avatech.edi.administrative.service;

import com.avatech.edi.administrative.config.ServiceException;
import com.avatech.edi.administrative.data.OpType;
import com.avatech.edi.administrative.model.bo.Account;
import com.avatech.edi.administrative.model.bo.MasterData;
import com.avatech.edi.administrative.model.bo.TaskRecord;
import com.avatech.edi.administrative.model.config.MasterDataType;
import com.avatech.edi.administrative.repository.IAccountRepository;
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
public class AccountService {

    private final Logger logger = LoggerFactory.getLogger(AccountService.class);

    @Autowired
    private TaskService taskService;

    @Autowired
    private IAccountRepository accountRepository;

    public List<Account> fetchUnSyncAccount(){
        List<TaskRecord> taskRecords = taskService.fetchTaskList(MasterDataType.ACCOUNT);
        if(taskRecords.size() == 0)
            return null;
        return fetchAccountByTask(taskRecords);
    }

    public List<Account> fetchUnSyncWithOpTypeAccount(String opType){
        List<TaskRecord> taskRecords = taskService.fetchTaskList(MasterDataType.ACCOUNT,opType);
        if(taskRecords.size() == 0)
            return null;
        return fetchAccountByTask(taskRecords);
    }

    public Account fetchAccount(String companyName,String uniqueKey){
        return  accountRepository.findByKey(MasterData.getUniqueKey(companyName,uniqueKey));
    }


    public List<Account> fetchAccountByTask(List<TaskRecord> taskRecords) {
        List<Account> accounts = new ArrayList<>();
        Account account;
        for (TaskRecord task : taskRecords) {
            try {
                account = accountRepository.findByKey(MasterData.getUniqueKey(task.getCompanyName(), task.getUniqueKey()));
                accounts.add(account);
            } catch (Exception e) {
                logger.error("查找科目错误：" + e.getMessage());
            }
        }
        return accounts;
    }
}
