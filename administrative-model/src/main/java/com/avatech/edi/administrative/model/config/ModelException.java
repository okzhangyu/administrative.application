package com.avatech.edi.administrative.model.config;

import com.avatech.common.edi.administrative.common.exception.BaseException;

public class ModelException extends BaseException {
    private String code;

    private String message;

    public ModelException() {
    }

    public ModelException(String message){
        super(message);
        this.message = message;
    }

    public ModelException(String code,String message){
        super(code,message);
        this.code = code;
        this.message = message;
    }
}
