package com.avatech.edi.administrative.model.bo;

import javax.persistence.*;
import java.time.DateTimeException;
import java.util.Date;
import java.util.List;

/**
 * Created by asus on 2018/9/7.
 */
@Entity
@Table(name = "AVA_OA_OJDT")
public class Voucher implements IVoucher {

    @Id
    @Column(name = "Docentry")
    private Integer docEntry;

    @Column(name = "Oanumber")
    private String oaNumber;

    @Column(name = "Companyname")
    private String companyName;

    @Column(name = "Docdate")
    private Date docDate;

    @Column(name = "Doctime")
    private Integer docTime;

    @Column(name = "comments")
    private String comments;

    @Column(name = "Issyncbone")
    private String isSyncBOne;

    @Column(name = "Issyncoa")
    private String isSyncOA;

    @Column(name = "Bonesyncmsg")
    private String boneSyncMsg;

    @Column(name = "Oasyncmsg")
    private String oaSyncMsg;

    @Column(name = "Createdate")
    private Date createDate;

    @Column(name = "Createtime")
    private Integer createTime;

    @Column(name = "Bonedocentry")
    private Integer boneDocEntry;

    @OneToMany
    @JoinTable(name = "AVA_OA_JDT1")
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
    public Integer getDocEntry() {
        return docEntry;
    }

    @Override
    public void setDocEntry(Integer docEntry) {
        this.docEntry = docEntry;
    }

    @Override
    public Integer getDocTime() {
        return docTime;
    }

    @Override
    public void setDocTime(Integer docTime) {
        this.docTime = docTime;
    }

    @Override
    public String getIsSyncBOne() {
        return isSyncBOne;
    }

    @Override
    public void setIsSyncBOne(String isSyncBOne) {
        this.isSyncBOne = isSyncBOne;
    }

    @Override
    public String getIsSyncOA() {
        return isSyncOA;
    }

    @Override
    public void setIsSyncOA(String isSyncOA) {
        this.isSyncOA = isSyncOA;
    }

    public String getBOneSyncMsg() {
        return boneSyncMsg;
    }

    public void setBOneSyncMsg(String boneSyncMsg) {
        this.boneSyncMsg = boneSyncMsg;
    }

    public String getOASyncMsg() {
        return oaSyncMsg;
    }

    public void setOASyncMsg(String oaSyncMsg) {
        this.oaSyncMsg = oaSyncMsg;
    }

    @Override
    public Date getCreateDate() {
        return createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public Integer getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    @Override
    public Integer getBOneDocEntry() {
        return boneDocEntry;
    }

    @Override
    public void setBOneDocEntry(Integer boneDocEntry) {
        this.boneDocEntry = boneDocEntry;
    }

    @Override
    public List<VoucherItem> getVoucherItems() {
        return voucherItems;
    }

    @Override
    public void setVoucherItems(List<VoucherItem> voucherItems) {
        this.voucherItems = voucherItems;
    }

    public Voucher() {

    }


}
