package com.avatech.edi.administrative.model.bo;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;

@Embeddable
public class VoucherItemKey implements Serializable {
    @Column(name = "Docentry")
    private Integer docEntry;

    @Column(name = "Linenum")
    private Integer lineNum;

    public VoucherItemKey() {
    }

    public Integer getDocEntry() {
        return docEntry;
    }

    public void setDocEntry(Integer docEntry) {
        this.docEntry = docEntry;
    }

    public Integer getLineNum() {
        return lineNum;
    }

    public void setLineNum(Integer lineNum) {
        this.lineNum = lineNum;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + ((docEntry == null) ? 0 : docEntry.hashCode());
        result = PRIME * result + ((lineNum == null) ? 0 : lineNum.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }

        final VoucherItemKey other = (VoucherItemKey)obj;
        if(docEntry == null){
            if(other.docEntry != null){
                return false;
            }
        }else if(!docEntry.equals(other.docEntry)){
            return false;
        }
        if(lineNum == null){
            if(other.lineNum != null){
                return false;
            }
        }else if(!lineNum.equals(other.lineNum)){
            return false;
        }

        return true;
    }
}
