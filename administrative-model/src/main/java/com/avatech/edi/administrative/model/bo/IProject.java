package com.avatech.edi.administrative.model.bo;
/**
 * Created by asus on 2018/9/7.
 */
public interface IProject {
     String getProjectCode();

     void setProjectCode(String projectCode);

     String getProjectName();

     void setProjectName(String projectName);

     String getActive();

     void setActive(String active);
}
