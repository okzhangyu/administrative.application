package com.avatech.edi.administrative.model.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by asus on 2018/9/12.
 */

@Entity
@Table(name="AVA_OA_TASK")
public class TaskRecord implements ITaskRecord {
    @Id
    @Column(name="docEntry")
    private Integer docEntry;

    @Column(name="objectCode")
    private String objectCode;

    @Column(name="companyDB")
    private String companyDB;

    @Column(name="uniqueKey")
    private String uniqueKey;

    @Column(name="isSync")
    private String isSync;

    @Column(name="errorTime")
    private Integer errorTime;

    @Column(name="syncMessage")
    private String syncMessage;

    @Column(name="opType")
    private String opType;

    @Column(name="createDate")
    private String createDate;

    @Column(name="createTime")
    private Integer createTime;

    @Column(name="syncDate")
    private String syncDate;

    @Column(name="syncTime")
    private Integer syncTime;

    public Integer getDocEntry() {
        return docEntry;
    }

    public void setDocEntry(Integer docEntry) {
        this.docEntry = docEntry;
    }

    public String getObjectCode() {
        return objectCode;
    }

    public void setObjectCode(String objectCode) {
        this.objectCode = objectCode;
    }

    public String getCompanyDB() {
        return companyDB;
    }

    public void setCompanyDB(String companyDB) {
        this.companyDB = companyDB;
    }

    public String getUniqueKey() {
        return uniqueKey;
    }

    public void setUniqueKey(String uniqueKey) {
        this.uniqueKey = uniqueKey;
    }

    public String getIsSync() {
        return isSync;
    }

    public void setIsSync(String isSync) {
        this.isSync = isSync;
    }

    public Integer getErrorTime() {
        return errorTime;
    }

    public void setErrorTime(Integer errorTime) {
        this.errorTime = errorTime;
    }

    public String getSyncMessage() {
        return syncMessage;
    }

    public void setSyncMessage(String syncMessage) {
        this.syncMessage = syncMessage;
    }

    public String getOpType() {
        return opType;
    }

    public void setOpType(String opType) {
        this.opType = opType;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public String getSyncDate() {
        return syncDate;
    }

    public void setSyncDate(String syncDate) {
        this.syncDate = syncDate;
    }

    public Integer getSyncTime() {
        return syncTime;
    }

    public void setSyncTime(Integer syncTime) {
        this.syncTime = syncTime;
    }

    public TaskRecord() {
    }

    public TaskRecord(Integer docEntry, String objectCode, String companyDB, String uniqueKey, String isSync, Integer errorTime, String syncMessage, String opType, String createDate, Integer createTime, String syncDate, Integer syncTime) {
        this.docEntry = docEntry;
        this.objectCode = objectCode;
        this.companyDB = companyDB;
        this.uniqueKey = uniqueKey;
        this.isSync = isSync;
        this.errorTime = errorTime;
        this.syncMessage = syncMessage;
        this.opType = opType;
        this.createDate = createDate;
        this.createTime = createTime;
        this.syncDate = syncDate;
        this.syncTime = syncTime;
    }
}
