package com.avatech.edi.administrative.model.bo;
import java.util.List;

/**
 * Created by asus on 2018/9/7.
 */
public interface IVoucher {
     String getOaNumber();

     void setOaNumber(String oaNumber);

     String getDocDate();

     void setDocDate(String docDate);

     String getComments();

     void setComments(String comments);

      List<VoucherItem> getVoucherItems();

      void setVoucherItems(List<VoucherItem> voucherItems);

}
