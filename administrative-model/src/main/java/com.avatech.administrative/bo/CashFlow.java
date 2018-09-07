package com.avatech.administrative.bo;

/**
 * Created by asus on 2018/9/7.
 */
public class CashFlow implements ICashFlow{
    private String cashFlowCode;
    private String cashFlowName;
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
