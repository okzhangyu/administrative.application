package com.avatech.edi.administrative.model.bo;

import javax.persistence.*;

/**
 * Created by asus on 2018/9/7.
 */


@Entity
@Table(name="AVA_OA_VIEW_OPRJ")
public class Project implements IProject {

    @Id
    @Column(name = "Uniquekey")
    private String key;

    @Column(name = "Companycode")
    private String companyName;

    @Column(name="DimCode")
     private  Integer dimCode;

    @Column(name="Projectcode")
    private String projectCode;

    @Column(name="Projectname")
    private String projectName;

    @Column(name="Active")
    private String active;

    @Override
    public String getProjectCode() {
        return projectCode;
    }

    @Override
    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    @Override
    public String getProjectName() {
        return projectName;
    }

    @Override
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public String getActive() {
        return active;
    }

    @Override
    public void setActive(String active) {
        this.active = active;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String getCompanyName() {
        return companyName;
    }

    @Override
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public Integer getDimCode() {
        return dimCode;
    }

    @Override
    public void setDimCode(Integer dimCode) {
        this.dimCode = dimCode;
    }

    @Override
    public String toString() {
        return "Project{" +
                "key:'" + key + '\'' +
                ", companyName:'" + companyName + '\'' +
                ", projectCode:'" + projectCode + '\'' +
                ", projectName:'" + projectName + '\'' +
                ", active:'" + active + '\'' +
                ", dimCode:'" + dimCode + '\'' +
                '}';
    }
}
