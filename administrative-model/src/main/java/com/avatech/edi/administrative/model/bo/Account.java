package com.avatech.edi.administrative.model.bo;

import javax.persistence.*;

/**
 * Created by asus on 2018/9/7.
 */

@Entity
@Table(name="AVA_OA_VIEW_OACT")
public class Account implements IAccount {

    @Id
    @Column(name = "Uniquekey")
    private String key;

    @Column(name = "Companycode")
    private String companyName;

    @Column(name="Acctcode")
    private String acctCode;

    @Column(name="Acctname")
    private String acctName;

    @Column(name="Active")
    private String active;

    @Column(name = "Acctlevel")
    private String acctLevel;

    @Column(name = "Firstlevelacctname")
    private String firstLevelAcctName;

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String getCompanyName() {
        return companyName;
    }

    @Override
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String getAcctCode() {
        return acctCode;
    }

    @Override
    public void setAcctCode(String acctCode) {
        this.acctCode = acctCode;
    }

    @Override
    public String getAcctName() {
        return acctName;
    }

    @Override
    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    @Override
    public String getActive() {
        return active;
    }

    @Override
    public void setActive(String active) {
        this.active = active;
    }

    @Override
    public String getAcctLevel() {
        return acctLevel;
    }

    @Override
    public void setAcctLevel(String acctLevel) {
        this.acctLevel = acctLevel;
    }

    @Override
    public String getFirstLevelAcctName() {
        return firstLevelAcctName;
    }

    @Override
    public void setFirstLevelAcctName(String firstLevelAcctName) {
        this.firstLevelAcctName=firstLevelAcctName;

    }

    @Override
    public String toString() {
        return "{" +
                "key:'" + key + '\'' +
                ", companyName:'" + companyName + '\'' +
                ", acctCode:'" + acctCode + '\'' +
                ", acctName:'" + acctName + '\'' +
                ", active:'" + active + '\'' +
                ", acctLevel:'" + acctLevel + '\'' +
                ", firstLevelName:'" + firstLevelAcctName + '\'' +
                '}';
    }
}
