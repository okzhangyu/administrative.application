package com.avatech.edi.administrative.model.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "AVA_OA_VIEW_OHEM")
public class Employee implements IEmployee {

    public static Map createEmpMap(Employee employee ,Boolean isAdd){
        Map empMap = new HashMap(){
            {
                put("orgAccountId", employee.getOrgAccountId());
                put("code", employee.getCode());//编号
                put("name", employee.getName());//姓名
                put("orgDepartmentId", employee.getOrgDepartmentId());//部门ID
                put("telNumber", employee.getTelNumber());//移动电话
                put("officeNum", "");//办公电话
                put("emailAddress", employee.getEmailAddress());//电子邮件
                put("gender", employee.getGender());//性别
                put("password", employee.getPassword());//密码
                put("loginName", employee.getLoginName());//登录名
                if(isAdd) {
                    put("orgLevelId", employee.getOrgLevelId());//职务ID
                    put("orgPostId", employee.getOrgPostId());//岗位ID
                    put("memberId",employee.getMemberId());
                }
            }
        };
        return empMap;
    }



    @Id
    @Column(name = "Code")
    private String code;

    @Column(name = "Name")
    private String name;

    @Column(name = "Orgid")
    private String orgAccountId;

    @Column(name = "deptid")
    private String orgDepartmentId;

    @Column(name = "deptcode")
    private String departCode;

    @Column(name = "Gender")
    private Integer gender;

    @Column(name = "Password")
    private String password;

    @Column(name = "Loginname")
    private String loginName;

    @Column(name = "Orglevelid")
    private String orgLevelId;

    @Column(name = "Orgpostid")
    private String orgPostId;

    @Column(name = "Telnumber")
    private String telNumber;

    @Column(name = "Emailaddress")
    private String emailAddress;

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getLoginName() {
        return loginName;
    }

    @Override
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    @Override
    public String getOrgLevelId() {
        return orgLevelId;
    }

    @Override
    public void setOrgLevelId(String orgLevelId) {
        this.orgLevelId = orgLevelId;
    }

    @Override
    public String getOrgPostId() {
        return orgPostId;
    }

    @Override
    public void setOrgPostId(String orgPostId) {
        this.orgPostId = orgPostId;
    }

    @Override
    public String getTelNumber() {
        return telNumber;
    }

    @Override
    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    @Override
    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getOrgAccountId() {
        return orgAccountId;
    }

    @Override
    public void setOrgAccountId(String orgAccountId) {
        this.orgAccountId = orgAccountId;
    }

    @Override
    public String getOrgDepartmentId() {
        return orgDepartmentId;
    }

    @Override
    public void setOrgDepartmentId(String orgDepartmentId) {
        this.orgDepartmentId = orgDepartmentId;
    }

    @Override
    public Integer getGender() {
        return gender;
    }

    @Override
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @Override
    public String getDepartCode() {
        return departCode;
    }

    @Override
    public void setDepartCode(String departCode) {
        this.departCode = departCode;
    }

    @Override
    public String getMemberId() {
        return null;
    }

    @Override
    public void setMemberId(String memberId) {


    }


}
