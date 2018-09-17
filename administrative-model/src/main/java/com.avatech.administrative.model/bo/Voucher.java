package com.avatech.administrative.model.bo;

import java.util.List;

/**
 * Created by asus on 2018/9/7.
 */
public class Voucher implements IVoucher {
    private String oaNumber;
    private String docDate;
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
    public String getDocDate() {
        return docDate;
    }

    @Override
    public void setDocDate(String docDate) {
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

    public List<VoucherItem> getVoucherItems() {
        return voucherItems;
    }

    public void setVoucherItems(List<VoucherItem> voucherItems) {
        this.voucherItems = voucherItems;
    }

    public Voucher() {
    }

    public Voucher(String oaNumber, String docDate, String comments, List<VoucherItem> voucherItems) {
        this.oaNumber = oaNumber;
        this.docDate = docDate;
        this.comments = comments;
        this.voucherItems = voucherItems;
    }
}
