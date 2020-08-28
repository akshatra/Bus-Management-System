package com.lti.dto;

public class Status {
    private StatusType Status;
    private String Message;

    public StatusType getStatus() {
        return Status;
    }

    public void setStatus(StatusType status) {
        Status = status;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public static enum StatusType {
        SUCCESS, FAILURE;
    }
    
}