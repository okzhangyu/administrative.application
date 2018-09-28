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

    @Column(name = "Deflevelid")
    private String defLevelId;

    @Column(name = "Defpositionid")
    private String defPositionId;


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

    @Override
    public String getDefLevelId() {
        return defLevelId;
    }

    @Override
    public void setDefLevelId(String defLevelId) {
        this.defLevelId = defLevelId;
    }

    @Override
    public String getDefPositionId() {
        return defPositionId;
    }

    @Override
    public void setDefPositionId(String defPositionId) {
        this.defPositionId = defPositionId;
    }
}
