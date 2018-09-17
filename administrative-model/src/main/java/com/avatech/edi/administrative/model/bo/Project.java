package com.avatech.edi.administrative.model.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by asus on 2018/9/7.
 */


@Entity
@Table(name="AVA_OA_VIEW_OPRJ")
public class Project implements IProject {

    @Column(name="ProjectCode")
    private String projectCode;

    @Column(name="ProjectName")
    private String projectName;

    @Column(name="Active")
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
