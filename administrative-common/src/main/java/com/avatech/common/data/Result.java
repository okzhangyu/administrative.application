package com.avatech.common.data;

import com.avatech.common.exception.BusinessException;

import java.util.List;

/**
 * Created by asus on 2018/9/12.
 */
public class Result<T> implements IResult<T> {
    private String code;
    private String message;
    private List<T> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Result() {
    }

    public Result(String code, String message, List<T> data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(BusinessException e){
        this.code = e.getCode();
        this.message = e.getMessage();
    }

     public Result(Exception e){
        this.code = ResultCode.FAIL;
        this.message = e.getMessage();
    }


}
