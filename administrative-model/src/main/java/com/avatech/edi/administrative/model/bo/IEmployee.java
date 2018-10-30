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

    String getLoginName();

    void setLoginName(String loginName);

    String getPassword();

    void setPassword(String password);

    Integer getGender();

    void setGender(Integer gender);

    String getOrgLevelId();

    void setOrgLevelId(String orgLevelId);

    String getOrgPostId();

    void setOrgPostId(String orgPostId);

    String getTelNumber();

    void setTelNumber(String telNumber);

    String getEmailAddress();

    void setEmailAddress(String emailAddress);

    String getDepartCode();

    void setDepartCode(String departCode);

    String  getMemberId();
    void   setMemberId(String memberId);
}
