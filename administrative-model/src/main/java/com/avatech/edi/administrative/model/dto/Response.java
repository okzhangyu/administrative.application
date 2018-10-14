package com.avatech.edi.administrative.model.dto;

import java.util.List;

public class Response {

    private String code;

    private String message;

    private List<ResponseRow> rows;

    public List<ResponseRow> getRows() {
        return rows;
    }

    public void setRows(List<ResponseRow> rows) {
        this.rows = rows;
    }

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

    @Override
    public String toString() {
        return "Response{" +
                "code:'" + code + '\'' +
                ", message:'" + message + '\'' +
                '}';
    }

}
