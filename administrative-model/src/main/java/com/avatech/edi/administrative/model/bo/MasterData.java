package com.avatech.edi.administrative.model.bo;

import org.hibernate.service.spi.ServiceException;

public class MasterData {

    public static String getUniqueKey(String company,String code){
//        if(company == null || code == null || company.isEmpty() || code.isEmpty()){
//            //throw new ServiceException()
//        }
        return company + "_" + code;

    }
}
