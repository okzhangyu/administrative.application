package com.avatech.edi.administrative.model.bo;
import java.util.Date;
import java.util.List;

/**
 * Created by asus on 2018/9/7.
 */
public interface IVoucher {

     Integer getDocEntry();

     void setDocEntry(Integer docEntry);

     String getOaNumber();

     void setOaNumber(String oaNumber);

     Date getDocDate();

     void setDocDate(Date docDate);

     Integer getDocTime();

     void setDocTime(Integer docTime);

     String getComments();

     void setComments(String comments);

     String getCompanyName();

     void setCompanyName(String companyName);

     Date getCreateDate();

     void setCreateDate(Date createDate);

     Integer getCreateTime();

     void setCreateTime(Integer createTime);

     String getIsSyncBOne();

     void setIsSyncBOne(String isSyncBOne);

     String getBOneSyncMsg();

     void setBOneSyncMsg(String bOneSyncMsg);

     String getIsSyncOA();

     void setIsSyncOA(String isSyncOA);

     String getOASyncMsg();

     void setOASyncMsg(String oaSyncMsg);

     Integer getBOneDocEntry();

     void setBOneDocEntry(Integer bOneDocEntry);

     List<VoucherItem> getVoucherItems();

     void setVoucherItems(List<VoucherItem> voucherItems);

}
