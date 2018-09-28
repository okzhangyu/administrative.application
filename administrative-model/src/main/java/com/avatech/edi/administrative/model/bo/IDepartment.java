package com.avatech.edi.administrative.model.bo;

import java.util.function.BinaryOperator;

public interface IDepartment {

    String getOrgAccountId();

    void setOrgAccountId(String orgId);

    String getCode();

    void setCode(String code);

    String getName();

    void setName(String name);

    String getDescription();

    void setDescription(String desc);

    Boolean getEnabled();

    void setEnabled(Boolean enabled);

    String getSuperior();

    void setSuperior(String superior);

    String getPath();

    void setPath(String path);

    Integer getSortId();

    void setSortId(Integer sortId);

    Boolean getIsGroup();

    void setIsGroup(Boolean isGroup);
}
