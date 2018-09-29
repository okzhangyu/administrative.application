package com.avatech.edi.administrative.model.bo;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AVA_OA_VIEW_OUDP")
public class Department implements IDepartment {


    @Id
    @Column(name = "Code")
    private String code;

    @Column(name = "Orgid")
    private String orgAccountId;

    @Column(name = "Name")
    private String name;

    @Column(name = "Desc")
    private String description;

    @Column(name = "Enabled")
    private Boolean enabled;

    @Column(name = "Superior")
    private String superior;

    @Column(name = "Path")
    private String path;

    @Column(name = "Sortid")
    private Integer sortId;

    @Column(name = "Isgroup")
    private Boolean isGroup;

    @Override
    public Integer getSortId() {
        return sortId;
    }

    @Override
    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    @Override
    public Boolean getIsGroup() {
        return isGroup;
    }

    @Override
    public void setIsGroup(Boolean group) {
        isGroup = group;
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
    public String getOrgAccountId() {
        return orgAccountId;
    }

    @Override
    public void setOrgAccountId(String orgAccountId) {
        this.orgAccountId = orgAccountId;
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
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Boolean getEnabled() {
        return enabled;
    }

    @Override
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String getSuperior() {
        return superior;
    }

    @Override
    public void setSuperior(String superior) {
        this.superior = superior;
    }

    @Override
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "{" +
                "code:'" + code + '\'' +
                ", orgAccountId:'" + orgAccountId + '\'' +
                ", name:'" + name + '\'' +
                ", description:'" + description + '\'' +
                ", enabled:'" + enabled + '\'' +
                ", superior:'" + superior + '\'' +
                ", path:'" + path + '\'' +
                '}';
    }
}
