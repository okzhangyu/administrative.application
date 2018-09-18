package com.avatech.edi.administrative.model.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by asus on 2018/9/7.
 */

@Entity
@Table(name="AVA_OA_VIEW_OACT")
public class Account implements IAccount {

    @Id
    @Column(name="Acctcode")
    private String acctCode;

    @Column(name="Acctname")
    private String acctName;

    @Column(name="Active")
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
