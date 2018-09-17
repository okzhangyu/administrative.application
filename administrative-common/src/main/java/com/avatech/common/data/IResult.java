package com.avatech.common.data;

import java.util.List;

/**
 * Created by asus on 2018/9/12.
 */
public interface IResult<T> {

     String getCode() ;

     void setCode(String code) ;

     String getMessage() ;

     void setMessage(String message) ;

     List<T> getData() ;

     void setData(List<T> data) ;
}
