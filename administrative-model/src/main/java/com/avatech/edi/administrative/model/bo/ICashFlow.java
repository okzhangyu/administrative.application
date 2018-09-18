package com.avatech.edi.administrative.model.bo;

/**
 * Created by asus on 2018/9/7.
 */
public interface ICashFlow {
     String getCashFlowCode();

     void setCashFlowCode(String cashFlowCode);

     String getCashFlowName();

     void setCashFlowName(String cashFlowName);

     String getActive();

     void setActive(String active);
}
