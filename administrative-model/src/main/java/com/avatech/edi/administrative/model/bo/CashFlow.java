package com.avatech.edi.administrative.model.bo;
import javax.persistence.*;

/**
 * Created by asus on 2018/9/7.
 */

@Entity
@Table(name="AVA_OA_VIEW_OCFW")
public class CashFlow implements ICashFlow{

    @Id
    @Column(name = "Uniquekey")
    private String key;

    @Column(name = "Companycode")
    private String companyName;

    @Column(name="Cashflowcode")
    private String cashFlowCode;

    @Column(name="Cashflowname")
    private String cashFlowName;

    @Column(name="Active")
    private String active;

    @Override
    public String getCashFlowCode() {
        return cashFlowCode;
    }

    @Override
    public void setCashFlowCode(String cashFlowCode) {
        this.cashFlowCode = cashFlowCode;
    }

    @Override
    public String getCashFlowName() {
        return cashFlowName;
    }

    @Override
    public void setCashFlowName(String cashFlowName) {
        this.cashFlowName = cashFlowName;
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

}
