package com.avatech.edi.administrative.model.bo;

import com.avatech.edi.administrative.model.config.ModelException;
import org.hibernate.service.spi.ServiceException;

public class MasterData {

    public static String getUniqueKey(String company,String code){
        if(company == null || code == null || company.isEmpty() || code.isEmpty()){
            throw new ModelException("公司代码或code值为空");
        }
        return company + "_" + code;

    }
}
