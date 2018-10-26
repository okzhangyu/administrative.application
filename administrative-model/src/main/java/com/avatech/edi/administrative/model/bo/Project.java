package com.avatech.edi.administrative.model.bo;

import jdk.nashorn.internal.ir.annotations.Ignore;

import javax.persistence.*;

/**
 * Created by asus on 2018/9/7.
 */


@Entity
@Table(name="AVA_OA_VIEW_OPRJ")
public class Project implements IProject {

    @Id
    @Ignore
    @Column(name = "Uniquekey")
    private String key;

    @Ignore
    @Column(name = "Companycode")
    private String companyName;

    @Column(name="Projectcode")
    private String projectCode;

    @Column(name="Projectname")
    private String projectName;

    @Column(name="Active")
    private String active;

    @Column(name="Dimcode")
    private  String dimcode;

    @Override
    public String getDimCode() {
        return dimcode;
    }

    @Override
    public void setDimCode(String dimCode) {
        dimCode = dimCode;
    }

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
    public String toString() {
        return "Project{" +
                "key:'" + key + '\'' +
                ", companyName:'" + companyName + '\'' +
                ", projectCode:'" + projectCode + '\'' +
                ", projectName:'" + projectName + '\'' +
                ", active:'" + active + '\'' +
                ", dimcode:'" + dimcode + '\'' +


                '}';
    }
}
