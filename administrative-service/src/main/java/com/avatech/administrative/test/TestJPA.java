package com.avatech.administrative.test;


import com.avatech.administrative.model.bo.Voucher;
import com.avatech.administrative.model.bo.VoucherItem;
import com.google.gson.Gson;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 2018/9/11.
 */


public class TestJPA {


    @Test
    public void testOutput(){
        Gson gson = new Gson();
        VoucherItem voucherItem = new VoucherItem();
        voucherItem.setAcctName("AcctName");
        voucherItem.setAccountCode("总账科目代码");
        voucherItem.setAccountName("总账科目名称");
        voucherItem.setCardCode("CardCode");
        voucherItem.setCashFlowCode("现金流编码");
        voucherItem.setControlCode("控制科目");
        voucherItem.setCredit(5000.0);
        voucherItem.setDebit(5000.0);
        voucherItem.setDistributionRule("分配规则");
        voucherItem.setLineNumber(1);
        voucherItem.setOcrCode("部门编码");
        voucherItem.setOcrCode2("人员编码");
        voucherItem.setProject("项目");
        voucherItem.setOaNumber("报销单号");
        voucherItem.setSummary("摘要");
        voucherItem.setVat(36.0);
        VoucherItem voucherItem2 = new VoucherItem();
        voucherItem2.setAcctName("AcctName");
        voucherItem2.setAccountCode("总账科目代码");
        voucherItem2.setAccountName("总账科目名称");
        voucherItem2.setCardCode("CardCode");
        voucherItem2.setCashFlowCode("现金流编码");
        voucherItem2.setControlCode("控制科目");
        voucherItem2.setCredit(5000.0);
        voucherItem2.setDebit(5000.0);
        voucherItem2.setDistributionRule("分配规则");
        voucherItem2.setLineNumber(2);
        voucherItem2.setOcrCode("部门编码");
        voucherItem2.setOcrCode2("人员编码");
        voucherItem2.setProject("项目");
        voucherItem2.setOaNumber("报销单号");
        voucherItem2.setSummary("摘要");
        voucherItem2.setVat(36.0);
        List<VoucherItem> voucherItems = new ArrayList<>();
        voucherItems.add(voucherItem);
        voucherItems.add(voucherItem2);
        Voucher voucher = new Voucher("报销单号","报销日期","备注",voucherItems);
        String voucherToJson = gson.toJson(voucher);
        System.out.println(voucherToJson);






   /*
        Gson gson = new Gson();
      *//*
        List<Account> accounts = new ArrayList<>();
        Account account = new Account();
        account.setAcctCode("科目编码");
        account.setAcctName("科目名称");
        account.setActive("Y");
        Account account2 = new Account();
        account2.setAcctCode("科目编码");
        account2.setAcctName("科目名称");
        account2.setActive("N");
        accounts.add(account);
        accounts.add(account2);
        String AccountToJson = gson.toJson(accounts);
        System.out.println(AccountToJson);

        Project project = new Project("项目编码","项目名称","Y");
        Project project2 = new Project("项目编码","项目名称","N");
        List<Project> projects = new ArrayList<>();
        projects.add(project);
        projects.add(project2);
        String projectToJson = gson.toJson(projects);
        System.out.println(projectToJson);

        CashFlow cashFlow = new CashFlow("现金流编码","报销日期","Y");
        CashFlow cashFlow2 = new CashFlow("现金流编码","报销日期","Y");
        List<CashFlow> cashFlows = new ArrayList<>();
        cashFlows.add(cashFlow);
        cashFlows.add(cashFlow2);
        String cashFlowToJson = gson.toJson(cashFlows);
        System.out.println(cashFlowToJson);

        Cost cost = new Cost("编码","名称",1,"Y");
        Cost cost2 = new Cost("编码","名称",2,"Y");
        List<Cost> costs = new ArrayList<>();
        costs.add(cost);
        costs.add(cost2);
        String costToJson = gson.toJson(costs);
        System.out.println(costToJson);
*//*
        VoucherItem voucherItem = new VoucherItem();
        voucherItem.setAcctName("AcctName");
        voucherItem.setAccountCode("总账科目代码");
        voucherItem.setAccountName("总账科目名称");
        voucherItem.setCardCode("CardCode");
        voucherItem.setCashFlowCode("现金流编码");
        voucherItem.setControlCode("控制科目");
        voucherItem.setCredit(5000.0);
        voucherItem.setDebit(5000.0);
        voucherItem.setDistributionRule("分配规则");
        voucherItem.setLineNumber(1);
        voucherItem.setOcrCode("部门编码");
        voucherItem.setOcrCode2("人员编码");
        voucherItem.setProject("项目");
        voucherItem.setOaNumber("报销单号");
        voucherItem.setSummary("摘要");
        voucherItem.setVat(36.0);
        VoucherItem voucherItem2 = new VoucherItem();
        voucherItem2.setAcctName("AcctName");
        voucherItem2.setAccountCode("总账科目代码");
        voucherItem2.setAccountName("总账科目名称");
        voucherItem2.setCardCode("CardCode");
        voucherItem2.setCashFlowCode("现金流编码");
        voucherItem2.setControlCode("控制科目");
        voucherItem2.setCredit(5000.0);
        voucherItem2.setDebit(5000.0);
        voucherItem2.setDistributionRule("分配规则");
        voucherItem2.setLineNumber(2);
        voucherItem2.setOcrCode("部门编码");
        voucherItem2.setOcrCode2("人员编码");
        voucherItem2.setProject("项目");
        voucherItem2.setOaNumber("报销单号");
        voucherItem2.setSummary("摘要");
        voucherItem2.setVat(36.0);
        List<VoucherItem> voucherItems = new ArrayList<>();
        voucherItems.add(voucherItem);
        voucherItems.add(voucherItem2);
        Voucher voucher = new Voucher("报销单号","报销日期","备注",voucherItems);
        String voucherToJson = gson.toJson(voucher);
        System.out.println(voucherToJson);


    */
    }
}
