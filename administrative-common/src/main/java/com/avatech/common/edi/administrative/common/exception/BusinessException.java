package com.avatech.common.edi.administrative.common.exception;

/**
 * Created by asus on 2018/9/13.
 */
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String code = "";

    public String getCode(){
        return code;
    }

    private String message = "";
    public String getMessage(){return message;}

    public BusinessException() {
    }

    public BusinessException(String message) {
        super(message);
        this.message = message;
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.message = message;
    }

    public BusinessException(String code,String message){
        super(message);
        this.code = code;
        this.message = message;
    }
}
