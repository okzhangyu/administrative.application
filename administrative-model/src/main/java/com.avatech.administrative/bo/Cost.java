package com.avatech.administrative.bo;

/**
 * Created by asus on 2018/9/7.
 */
public class Cost implements ICost{
    private String proCode;
    private String proName;
    private Integer dimCode;
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

    public Cost() {
    }

    public Cost(String proCode, String proName, Integer dimCode, String active) {
        this.proCode = proCode;
        this.proName = proName;
        this.dimCode = dimCode;
        this.active = active;
    }
}
