package com.avatech.edi.administrative.model.bo;

import javax.persistence.*;

/**
 * Created by asus on 2018/9/7.
 */

@Entity
@Table(name="AVA_OA_VIEW_OPRC")
public class CostCenter implements ICostCenter {

    @Id
    @Column(name = "Key")
    private String key;

    @Column(name = "Companyname")
    private String companyName;

    @Column(name="Prccode")
    private String proCode;

    @Column(name="Prcname")
    private String proName;

    @Column(name="Dimcode")
    private Integer dimCode;

    @Column(name="Active")
    private String active;

    @Override
    public String getProCode() {
        return proCode;
    }

    @Override
    public void setProCode(String proCode) {
        this.proCode = proCode;
    }

    @Override
    public String getProName() {
        return proName;
    }

    @Override
    public void setProName(String proName) {
        this.proName = proName;
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
}
