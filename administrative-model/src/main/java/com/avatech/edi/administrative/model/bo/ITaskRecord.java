package com.avatech.edi.administrative.model.bo;

/**
 * Created by asus on 2018/9/12.
 */
public interface ITaskRecord {


     Integer getDocEntry();

     void setDocEntry(Integer docEntry);

     String getObjectCode();

     void setObjectCode(String objectCode);

     String getCompanyName();

     void setCompanyName(String companyName);

     String getUniqueKey();

     void setUniqueKey(String uniqueKey);

     String getIsSync();

     void setIsSync(String isSync);

     Integer getErrorTime();

     void setErrorTime(Integer errorTime);

     String getSyncMessage() ;

     void setSyncMessage(String syncMessage);

     String getOpType();

     void setOpType(String opType);

     String getCreateDate();

     void setCreateDate(String createDate);

     Integer getCreateTime();

     void setCreateTime(Integer createTime);

     String getSyncDate();

     void setSyncDate(String syncDate);

     Integer getSyncTime();

     void setSyncTime(Integer syncTime);

     String getLineNum();
     void  setLineNum(String lineNum);
}
