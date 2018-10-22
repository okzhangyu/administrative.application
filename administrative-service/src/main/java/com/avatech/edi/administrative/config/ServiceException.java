package com.avatech.edi.administrative.config;

import com.avatech.common.edi.administrative.common.exception.BaseException;

public class ServiceException extends BaseException {
    private String code;

    private String message;

    @Override
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ServiceException() {
    }

    public ServiceException(String message){
        super();
        this.message = message;
    }

    public ServiceException(String code,String message){
        super();
        this.code = code;
        this.message = message;
    }
}
