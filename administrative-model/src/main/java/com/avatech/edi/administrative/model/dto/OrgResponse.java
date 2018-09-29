package com.avatech.edi.administrative.model.dto;

import com.avatech.edi.administrative.model.config.ErrorMsgDeserializer;
import com.avatech.edi.administrative.model.config.ListDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

public class OrgResponse {

    private Boolean success;

    private List<ErrorMsgs> errorMsgs;

    private List<SuccessMsgs> successMsgs;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<ErrorMsgs> getErrorMsgs() {
        return errorMsgs;
    }

    @JsonDeserialize(using = ListDeserializer.class,as = List.class,contentAs = ErrorMsgs.class)
    public void setErrorMsgs(List<ErrorMsgs> errorMsgs) {
        this.errorMsgs = errorMsgs;
    }

    public List<SuccessMsgs> getSuccessMsgs() {
        return successMsgs;
    }

    @JsonDeserialize(using = ListDeserializer.class,as = List.class,contentAs = SuccessMsgs.class)
    public void setSuccessMsgs(List<SuccessMsgs> successMsgs) {
        this.successMsgs = successMsgs;
    }

    public class ErrorMsgs{
        private String code;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }

    public class SuccessMsgs{
        private String code;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }

}

