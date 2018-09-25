package com.avatech.edi.administrative.model.bo;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by asus on 2018/9/12.
 */
@Embeddable
public class UniqueKey implements Serializable {

    @Column(name = "Code")
    private String code;

    @Column(name = "Companyname")
    private String companyName;

    public UniqueKey() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + ((code == null) ? 0 : code.hashCode());
        result = PRIME * result + ((companyName == null) ? 0 : companyName.hashCode());
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

        final UniqueKey other = (UniqueKey)obj;
        if(code == null){
            if(other.code != null){
                return false;
            }
        }else if(!code.equals(other.code)){
            return false;
        }
        if(companyName == null){
            if(other.companyName != null){
                return false;
            }
        }else if(!companyName.equals(other.companyName)){
            return false;
        }

        return true;
    }
}
