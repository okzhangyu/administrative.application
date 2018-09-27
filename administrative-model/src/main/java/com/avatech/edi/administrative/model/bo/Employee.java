package com.avatech.edi.administrative.model.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AVA_OA_OHEM")
public class Employee implements IEmployee {

    @Id
    @Column(name = "Code")
    private String code;

    @Column(name = "Name")
    private String name;

    @Column(name = "Orgid")
    private String orgAccountId;

    @Column(name = "deptid")
    private String orgDepartmentId;

    @Column(name = "Enabled")
    private boolean enabled;

    @Column(name = "Gender")
    private Integer gender;

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

    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public Integer getGender() {
        return gender;
    }

    @Override
    public void setGender(Integer gender) {
        this.gender = gender;
    }
}
