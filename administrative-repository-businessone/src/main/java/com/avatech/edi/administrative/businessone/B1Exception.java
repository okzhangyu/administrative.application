package com.avatech.edi.administrative.businessone;


import com.avatech.common.edi.administrative.common.exception.BaseException;

public class B1Exception extends BaseException {

    private String code;

    private String message;

    public B1Exception(String code,String message){
        super(code,message);
        this.code = code;
        this.message = message;
    }

    public B1Exception() {super();}

    public B1Exception(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    public B1Exception(String arg0) {
        super(arg0);
    }

    public B1Exception(Throwable arg0) {
        super(arg0);
    }
}
