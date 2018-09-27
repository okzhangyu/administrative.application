package com.avatech.edi.administrative.model.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AVA_OA_COMPANY")
public class Company implements ICompany {

    @Id
    @Column(name = "orgid")
    private String orgAccountId;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "Path")
    private String path;

    @Override
    public String getOrgAccountId() {
        return orgAccountId;
    }

    @Override
    public void setOrgAccountId(String orgAccountId) {
        this.orgAccountId = orgAccountId;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
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
    public String getPath() {
        return path;
    }

    @Override
    public void setPath(String path) {
        this.path = path;
    }
}
