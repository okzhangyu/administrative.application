package com.avatech.administrative.model.bo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by asus on 2018/9/7.
 */

@Entity
@Table(name="AVA_OA_VIEW_OCFW")
public class CashFlow implements ICashFlow {
    @Column(name="CashFlowCode")
    private String cashFlowCode;

    @Column(name="CashFlowName")
    private String cashFlowName;

    @Column(name="Active")
    private String active;

    public String getCashFlowCode() {
        return cashFlowCode;
    }

    public void setCashFlowCode(String cashFlowCode) {
        this.cashFlowCode = cashFlowCode;
    }

    public String getCashFlowName() {
        return cashFlowName;
    }

    public void setCashFlowName(String cashFlowName) {
        this.cashFlowName = cashFlowName;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public CashFlow() {
    }

    public CashFlow(String cashFlowCode, String cashFlowName, String active) {
        this.cashFlowCode = cashFlowCode;
        this.cashFlowName = cashFlowName;
        this.active = active;
    }
}
