package com.avatech.edi.administrative.model.bo;

/**
 * Created by asus on 2018/9/7.
 */
public interface IVoucherItem {

      String getOANumber();

      void setOANumber(String oaNumber);

      String getAccountCode();

      void setAccountCode(String accountCode);

      String getAccountName();

      void setAccountName(String accountName);

      Double getCredit();

      void setCredit(Double credit);

      Double getDebit();

      void setDebit(Double debit);

      String getOcrCode();

      void setOcrCode(String ocrCode);

      String getOcrCode2();

      void setOcrCode2(String ocrCode2);

      String getSummary();

      void setSummary(String summary);

      String getProject();

      void setProject(String project);

      String getCashFlowCode();

      void setCashFlowCode(String cashFlowCode);

      String getCardCode();

      void setCardCode(String cardCode);

      String getControlCode();

      void setControlCode(String controlCode);

      String getShortName();

      void setShortName(String shortName);
}
