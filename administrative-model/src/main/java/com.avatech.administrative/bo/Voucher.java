package com.avatech.administrative.bo;

/**
 * Created by asus on 2018/9/7.
 */
public class Voucher implements IVoucher{
    private String oaNumber;
    private String docDate;
    private String comments;

    public String getOaNumber() {
        return oaNumber;
    }

    public void setOaNumber(String oaNumber) {
        this.oaNumber = oaNumber;
    }

    public String getDocDate() {
        return docDate;
    }

    public void setDocDate(String docDate) {
        this.docDate = docDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Voucher() {
    }

    public Voucher(String oaNumber, String docDate, String comments) {
        this.oaNumber = oaNumber;
        this.docDate = docDate;
        this.comments = comments;
    }
}
