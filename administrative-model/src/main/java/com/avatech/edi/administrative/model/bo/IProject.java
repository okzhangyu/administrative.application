package com.avatech.edi.administrative.model.bo;

import javax.persistence.Id;

/**
 * Created by asus on 2018/9/7.
 */
public interface IProject {

     String getKey();

     void setKey(String key);

     String getCompanyName();

     void setCompanyName(String companyName);

     String getProjectCode();

     void setProjectCode(String projectCode);

     String getProjectName();

     void setProjectName(String projectName);

     String getActive();

     void setActive(String active);

     String getContractNo();
     void setContractNo(String contractNo);

     String getContractName();
     void  setContractName(String contractName);

     String getWorkOrderNo();
     void  setWorkOrderNo(String workOrderNo);

     String getWorkOrderName();
     void setWorkOrderName(String workOrderName);

     String getItemNo();
     void setItemNo(String itemNo);




}
