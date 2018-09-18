package com.avatech.edi.administrative.model.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by asus on 2018/9/7.
 */

@Entity
@Table(name="AVA_OA_VIEW_OPRC")
public class CostCenter implements ICostCenter {

    @Id
    @Column(name="Prccode")
    private String proCode;

    @Column(name="Prcname")
    private String proName;

    @Column(name="Dimcode")
    private Integer dimCode;

    @Column(name="Active")
    private String active;

    public String getProCode() {
        return proCode;
    }

    public void setProCode(String proCode) {
        this.proCode = proCode;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public Integer getDimCode() {
        return dimCode;
    }

    public void setDimCode(Integer dimCode) {
        this.dimCode = dimCode;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public CostCenter() {
    }

    public CostCenter(String proCode, String proName, Integer dimCode, String active) {
        this.proCode = proCode;
        this.proName = proName;
        this.dimCode = dimCode;
        this.active = active;
    }
}
