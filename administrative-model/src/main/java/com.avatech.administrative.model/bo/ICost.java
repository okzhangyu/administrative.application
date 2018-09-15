package com.avatech.administrative.model.bo;

/**
 * Created by asus on 2018/9/7.
 */
public interface ICost {
     String getProCode();

     void setProCode(String proCode);

     String getProName();

     void setProName(String proName);

     Integer getDimCode();

     void setDimCode(Integer dimCode);

     String getActive();

     void setActive(String active);
}
