package com.avatech.edi.administrative.model.bo;
import java.util.Date;
import java.util.List;

/**
 * Created by asus on 2018/9/7.
 */
public interface IVoucher {

     String getOaNumber();

     void setOaNumber(String oaNumber);

     Date getDocDate();

     void setDocDate(Date docDate);

     String getComments();

     void setComments(String comments);

     String getCompanyName();

     void setCompanyName(String companyName);

     List<VoucherItem> getVoucherItems();

     void setVoucherItems(List<VoucherItem> voucherItems);

}
