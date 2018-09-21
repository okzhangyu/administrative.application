package com.avatech.common.edi.administrative.common.Utils;

public class StringUtils {

    public static Boolean isEmpty(String value){
        if(value == null)
            return  true;
        if(value.isEmpty())
            return true;
        return false;
    }
}
