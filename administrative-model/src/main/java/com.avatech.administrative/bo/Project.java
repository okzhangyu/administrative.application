package com.avatech.administrative.bo;

/**
 * Created by asus on 2018/9/7.
 */
public class Project implements IProject{
    private String projectCode;
    private String projectName;
    private String active;

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public Project() {
    }

    public Project(String projectCode, String projectName, String active) {
        this.projectCode = projectCode;
        this.projectName = projectName;
        this.active = active;
    }
}
