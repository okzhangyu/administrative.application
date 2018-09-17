package com.avatech.administrative.model.bo;

/**
 * Created by asus on 2018/9/7.
 */
public class VoucherItem implements IVoucherItem {
    private String oaNumber;
    private Integer lineNumber;
    private String accountCode;
    private String accountName;
    private Double credit;
    private Double debit;
    private String ocrCode;
    private String ocrCode2;
    private String summary;
    private String project;
    private String cashFlowCode;
    private String distributionRule;
    private String cardCode;
    private Double vat;
    private String controlCode;
    private String acctName;


    @Override
    public String getOaNumber() {
        return oaNumber;
    }

    @Override
    public void setOaNumber(String oaNumber) {
        this.oaNumber = oaNumber;
    }

    @Override
    public Integer getLineNumber() {
        return lineNumber;
    }

    @Override
    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
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
    public Double getCredit() {
        return credit;
    }

    @Override
    public void setCredit(Double credit) {
        this.credit = credit;
    }

    @Override
    public Double getDebit() {
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
    public String getDistributionRule() {
        return distributionRule;
    }

    @Override
    public void setDistributionRule(String distributionRule) {
        this.distributionRule = distributionRule;
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
    public Double getVat() {
        return vat;
    }

    @Override
    public void setVat(Double vat) {
        this.vat = vat;
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
    public String getAcctName() {
        return acctName;
    }

    @Override
    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    public VoucherItem() {
    }

    public VoucherItem(String oaNumber, Integer lineNumber, String accountCode, String accountName, Double credit, Double debit, String ocrCode, String ocrCode2, String summary, String project, String cashFlowCode, String distributionRule, String cardCode, Double vat, String controlCode, String acctName) {
        this.oaNumber = oaNumber;
        this.lineNumber = lineNumber;
        this.accountCode = accountCode;
        this.accountName = accountName;
        this.credit = credit;
        this.debit = debit;
        this.ocrCode = ocrCode;
        this.ocrCode2 = ocrCode2;
        this.summary = summary;
        this.project = project;
        this.cashFlowCode = cashFlowCode;
        this.distributionRule = distributionRule;
        this.cardCode = cardCode;
        this.vat = vat;
        this.controlCode = controlCode;
        this.acctName = acctName;
    }
}
