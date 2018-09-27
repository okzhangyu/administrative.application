package com.avatech.edi.administrative.model.bo;

import org.omg.PortableInterceptor.INACTIVE;

public interface IEmployee {

    String getCode();

    void setCode(String code);

    String getName();

    void setName(String name);

    String getOrgAccountId();

    void setOrgAccountId(String orgId);

    String getOrgDepartmentId();

    void setOrgDepartmentId(String orgDepartmentId);

    boolean isEnabled();

    void setEnabled(boolean enabled);

    Integer getGender();

    void setGender(Integer gender);
}
