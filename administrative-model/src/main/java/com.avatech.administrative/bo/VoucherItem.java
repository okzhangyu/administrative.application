package com.avatech.administrative.bo;

/**
 * Created by asus on 2018/9/7.
 */
public class VoucherItem implements IVoucherItem{
    private String oaNumber;
    private Integer lineNumber;
    private String AccountCode;
    private String AccountName;
    private Double credit;
    private Double debit;
    private String ocrCode;
    private String ocrCode2;
    private String Summary;
    private String Project;
    private String CashFlowCode;
    private String DistributionRule;
    private String CardCode;
    private Double Vat;
    private String ControlCode;
    private String AcctName;

    public String getOaNumber() {
        return oaNumber;
    }

    public void setOaNumber(String oaNumber) {
        this.oaNumber = oaNumber;
    }

    public Integer getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getAccountCode() {
        return AccountCode;
    }

    public void setAccountCode(String accountCode) {
        AccountCode = accountCode;
    }

    public String getAccountName() {
        return AccountName;
    }

    public void setAccountName(String accountName) {
        AccountName = accountName;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public Double getDebit() {
        return debit;
    }

    public void setDebit(Double debit) {
        this.debit = debit;
    }

    public String getOcrCode() {
        return ocrCode;
    }

    public void setOcrCode(String ocrCode) {
        this.ocrCode = ocrCode;
    }

    public String getOcrCode2() {
        return ocrCode2;
    }

    public void setOcrCode2(String ocrCode2) {
        this.ocrCode2 = ocrCode2;
    }

    public String getSummary() {
        return Summary;
    }

    public void setSummary(String summary) {
        Summary = summary;
    }

    public String getProject() {
        return Project;
    }

    public void setProject(String project) {
        Project = project;
    }

    public String getCashFlowCode() {
        return CashFlowCode;
    }

    public void setCashFlowCode(String cashFlowCode) {
        CashFlowCode = cashFlowCode;
    }

    public String getDistributionRule() {
        return DistributionRule;
    }

    public void setDistributionRule(String distributionRule) {
        DistributionRule = distributionRule;
    }

    public String getCardCode() {
        return CardCode;
    }

    public void setCardCode(String cardCode) {
        CardCode = cardCode;
    }

    public Double getVat() {
        return Vat;
    }

    public void setVat(Double vat) {
        Vat = vat;
    }

    public String getControlCode() {
        return ControlCode;
    }

    public void setControlCode(String controlCode) {
        ControlCode = controlCode;
    }

    public String getAcctName() {
        return AcctName;
    }

    public void setAcctName(String acctName) {
        AcctName = acctName;
    }

    public VoucherItem() {
    }

    public VoucherItem(String oaNumber, Integer lineNumber, String accountCode, String accountName, Double credit, Double debit, String ocrCode, String ocrCode2, String summary, String project, String cashFlowCode, String distributionRule, String cardCode, Double vat, String controlCode, String acctName) {
        this.oaNumber = oaNumber;
        this.lineNumber = lineNumber;
        AccountCode = accountCode;
        AccountName = accountName;
        this.credit = credit;
        this.debit = debit;
        this.ocrCode = ocrCode;
        this.ocrCode2 = ocrCode2;
        Summary = summary;
        Project = project;
        CashFlowCode = cashFlowCode;
        DistributionRule = distributionRule;
        CardCode = cardCode;
        Vat = vat;
        ControlCode = controlCode;
        AcctName = acctName;
    }
}
