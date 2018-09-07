package com.avatech.administrative.bo;

/**
 * Created by asus on 2018/9/7.
 */
public class Account implements IAccount{
    private String acctCode;
    private String acctName;
    private String active;

    public String getAcctCode() {
        return acctCode;
    }

    public void setAcctCode(String acctCode) {
        this.acctCode = acctCode;
    }

    public String getAcctName() {
        return acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public Account() {
    }

    public Account(String acctCode, String acctName, String active) {
        this.acctCode = acctCode;
        this.acctName = acctName;
        this.active = active;
    }
}
