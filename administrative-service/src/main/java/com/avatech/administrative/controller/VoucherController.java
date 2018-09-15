package com.avatech.administrative.controller;


import com.avatech.administrative.model.bo.UniqueKey;
import com.avatech.administrative.model.bo.Voucher;
import com.avatech.administrative.service.IProjectService;
import com.avatech.common.data.PromptMessage;
import com.avatech.common.data.Result;
import com.avatech.common.data.ResultCode;
import com.avatech.common.data.ResultDescription;
import com.avatech.common.exception.BusinessException;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by asus on 2018/9/12.
 */



@Slf4j
@CrossOrigin
@RestController
@RequestMapping("administrative")
public class VoucherController implements IVoucherController {

    @Autowired
    private IProjectService projectService;


    @PostMapping("voucher")
    public Result generateVoucher(@RequestBody Voucher voucher){
        Gson gson = new Gson();
        log.info(PromptMessage.PROMPT_VOUCHER_PARAMETER+gson.toJson(voucher));
        Result result = new Result();
        UniqueKey uniqueKey = new UniqueKey();
        List<UniqueKey> uniqueKeys = new ArrayList<>();
        try {
            uniqueKey.setUniqueKey(267);
            uniqueKeys.add(uniqueKey);
            result = new Result(ResultCode.SUCCESS, ResultDescription.SUCCESS,uniqueKeys);
        }catch (BusinessException e){
            log.error(PromptMessage.PROMPT_VOUCHER_ERROR+e.getMessage());
            result = new Result(e);
        }catch (Exception e){
            log.error(PromptMessage.PROMPT_VOUCHER_ERROR+e.getMessage());
            result = new Result(e);
        }

        return result;
    }

   /* @GetMapping("project")
    public Result<Project> getProjects(){
        Result result = new Result();
        try {
            List<Project> projects = projectService.fetchProjects();
            result = new Result(ResultCode.SUCCESS, ResultDescription.SUCCESS,projects);
            log.info("找到了！！！！！每隔30秒执行一次");
        }catch (BusinessException e){
            log.error(PromptMessage.PROMPT_VOUCHER_ERROR+e.getMessage());
            result = new Result(e);
        }catch (Exception e){
            log.error(PromptMessage.PROMPT_VOUCHER_ERROR+e.getMessage());
            result = new Result(e);
        }
        return result;

    }*/


}
