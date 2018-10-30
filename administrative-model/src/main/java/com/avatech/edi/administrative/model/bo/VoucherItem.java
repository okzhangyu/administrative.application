package com.avatech.edi.administrative.model.bo;

import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by asus on 2018/9/7.
 */
public class  VoucherItem implements IVoucherItem {

    private String oaNumber;
    private String accountCode;
    private String accountName;
    private Double credit;
    private Double debit;
    private String ocrCode;
    private String ocrCode2;
    private String summary;
    private String project;
    private String cashFlowCode;
    private String cardCode;
    private String controlCode;
    private String shortName;
    private String contractNo;
    private String workOrderNo;

    @Override
    public String getOANumber() {
        return oaNumber;
    }

    @Override
    public void setOANumber(String oaNumber) {
        this.oaNumber = oaNumber;
    }


    @Override
    public String getAccountCode() {
        return accountCode;
    }

    @Override
    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    @Override
    public String getAccountName() {
        return accountName;
    }

    @Override
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Override
    public String getContractNo() {
        return contractNo;
    }

    @Override
    public void setContractNo(String contractNo) {
       this.contractNo = contractNo;
    }

    @Override
    public String getWorkOrderNo() {
        return workOrderNo;
    }

    @Override
    public void setWorkOrderNo(String workOrderNo) {
       this.workOrderNo = workOrderNo;
    }

    @Override
    public Double getCredit() {
        if(credit == null)
            return 0.0;
        return credit;
    }

    @Override
    public void setCredit(Double credit) {
        this.credit = credit;
    }

    @Override
    public Double getDebit() {
        if(debit == null)
            return 0.0;
        return debit;
    }

    @Override
    public void setDebit(Double debit) {
        this.debit = debit;
    }

    @Override
    public String getOcrCode() {
        return ocrCode;
    }

    @Override
    public void setOcrCode(String ocrCode) {
        this.ocrCode = ocrCode;
    }

    @Override
    public String getOcrCode2() {
        return ocrCode2;
    }

    @Override
    public void setOcrCode2(String ocrCode2) {
        this.ocrCode2 = ocrCode2;
    }

    @Override
    public String getSummary() {
        return summary;
    }

    @Override
    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String getProject() {
        return project;
    }

    @Override
    public void setProject(String project) {
        this.project = project;
    }

    @Override
    public String getCashFlowCode() {
        return cashFlowCode;
    }

    @Override
    public void setCashFlowCode(String cashFlowCode) {
        this.cashFlowCode = cashFlowCode;
    }

    @Override
    public String getCardCode() {
        return cardCode;
    }

    @Override
    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    @Override
    public String getControlCode() {
        return controlCode;
    }

    @Override
    public void setControlCode(String controlCode) {
        this.controlCode = controlCode;
    }

    @Override
    public String getShortName() {
        return shortName;
    }

    @Override
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Override
    public String toString() {
        return "VoucherItem{" +
                "oaNumber:'" + oaNumber + '\'' +
                ", accountCode:'" + accountCode + '\'' +
                ", accountName:'" + accountName + '\'' +
                ", credit=" + credit +
                ", debit=" + debit +
                ", ocrCode:'" + ocrCode + '\'' +
                ", ocrCode2:'" + ocrCode2 + '\'' +
                ", summary:'" + summary + '\'' +
                ", project:'" + project + '\'' +
                ", cashFlowCode:'" + cashFlowCode + '\'' +
                ", cardCode:'" + cardCode + '\'' +
                ", controlCode:'" + controlCode + '\'' +
                ", shortName:'" + shortName + '\'' +
                ", workOrderNo:'" + workOrderNo + '\'' +
                ", contractNo:'" +  contractNo+ '\'' +
                '}';
    }
}
