package com.avatech.edi.administrative.config;

public class ServiceException extends RuntimeException{
    private String code;

    private String message;

    public ServiceException() {
    }

    public ServiceException(String code,String message){
        super();
        this.code = code;
        this.message = message;
    }
}
