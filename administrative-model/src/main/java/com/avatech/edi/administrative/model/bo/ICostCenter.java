package com.avatech.edi.administrative.model.bo;

/**
 * Created by asus on 2018/9/7.
 */
public interface ICostCenter {

     String getKey();

     void setKey(String key);

     String getCompanyName();

     void setCompanyName(String companyName);

     String getProCode();

     void setProCode(String proCode);

     String getProName();

     void setProName(String proName);

     Integer getDimCode();

     void setDimCode(Integer dimCode);

     String getActive();

     void setActive(String active);
}
