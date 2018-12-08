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
    @Column(name = "Uniquekey")
    private String key;

    @Ignore
    @Column(name = "Companycode")
    private String companyName;

    @Column(name="Prjcode")
    private String projectCode;

    @Column(name="Prjname")
    private String projectName;

    @Column(name="Active")
    private String active;

    @Column(name = "Contractno")
    private String contractNo;

    @Column(name = "Contractname")
    private String contractName;

    @Column(name = "Workorderno")
    private String workOrderNo;

    @Column(name = "Workordername")
    private String workOrderName;


    @Column(name = "Itemno")
    private String itemNo;




    @Override
    public String getContractNo() {
        return contractNo;
    }

    @Override
    public void setContractNo(String contractNo) {
        this.contractNo=contractNo;

    }

    @Override
    public String getContractName() {
        return contractName;
    }

    @Override
    public void setContractName(String contractName) {
        this.contractName=contractName;

    }

    @Override
    public String getWorkOrderNo() {
        return workOrderNo;
    }

    @Override
    public void setWorkOrderNo(String workOrderNo) {
        this.workOrderName=workOrderNo;
    }

    @Override
    public String getWorkOrderName() {
        return workOrderName;
    }

    @Override
    public void setWorkOrderName(String workOrderName) {
        this.workOrderName=workOrderName;
    }

    @Override
    public String getItemNo() {
        return itemNo;
    }

    @Override
    public void setItemNo(String itemNo) {
        this.itemNo=itemNo;
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
                ", contractNo:'" + contractName + '\'' +
                ", contractName:'" + contractName + '\'' +
                ", workOrderNo:'" + workOrderName + '\'' +
                ", workOrderName:'" + workOrderName + '\'' +

                '}';
    }
}
