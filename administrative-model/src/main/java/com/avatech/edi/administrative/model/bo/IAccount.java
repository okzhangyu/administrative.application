package com.avatech.edi.administrative.model.bo;

/**
 * Created by asus on 2018/9/7.
 */
public interface IAccount {
     String getAcctCode();

     void setAcctCode(String acctCode);

     String getAcctName();

     void setAcctName(String acctName);

     String getActive();

     void setActive(String active);
}
