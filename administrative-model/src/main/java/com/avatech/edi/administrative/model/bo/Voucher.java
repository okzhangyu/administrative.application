package com.avatech.edi.administrative.model.bo;

import javax.persistence.*;
import java.time.DateTimeException;
import java.util.Date;
import java.util.List;

/**
 * Created by asus on 2018/9/7.
 */
public class Voucher implements IVoucher {


    private String oaNumber;
    private String companyName;
    private Date docDate;
    private String comments;

    private List<VoucherItem> voucherItems;

    @Override
    public String getOaNumber() {
        return oaNumber;
    }

    @Override
    public void setOaNumber(String oaNumber) {
        this.oaNumber = oaNumber;
    }

    @Override
    public Date getDocDate() {
        return docDate;
    }

    @Override
    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    @Override
    public String getComments() {
        return comments;
    }

    @Override
    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String getCompanyName() {
        return companyName;
    }

    @Override
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public List<VoucherItem> getVoucherItems() {
        return voucherItems;
    }

    @Override
    public void setVoucherItems(List<VoucherItem> voucherItems) {
        this.voucherItems = voucherItems;
    }

    @Override
    public String toString() {
        return "Voucher{" +
                "oaNumber:'" + oaNumber + '\'' +
                ", companyName:'" + companyName + '\'' +
                ", docDate:" + docDate +
                ", comments:'" + comments + '\'' +
                ", voucherItems:" + voucherItems +
                '}';
    }

    public Voucher() {

    }


}
