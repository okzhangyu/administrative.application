package com.avatech.edi.administrative.model.bo;

import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by asus on 2018/9/7.
 */
@Entity
@Table(name = "AVA_OA_JDT1")
public class VoucherItem implements IVoucherItem {

    @EmbeddedId
    private VoucherItemKey dataTempleKey;

    @Column(name = "Oanumber")
    private String oaNumber;

    @Column(name = "Accountcode")
    private String accountCode;

    @Column(name = "Accountname")
    private String accountName;

    @Column(name = "Credit")
    private Double credit;

    @Column(name = "Debit")
    private Double debit;

    @Column(name = "Ocrcode")
    private String ocrCode;

    @Column(name = "Ocrcode2")
    private String ocrCode2;

    @Column(name = "Summary")
    private String summary;

    @Column(name = "Project")
    private String project;

    @Column(name = "Cashflowcode")
    private String cashFlowCode;

    @Column(name = "Cardcode")
    private String cardCode;

    @Column(name = "Vat")
    private Double vat;

    @Column(name = "Controlcode")
    private String controlCode;

    @Column(name = "Shortname")
    private String shortName;


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
    public String getShortName() {
        return shortName;
    }

    @Override
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }


}
