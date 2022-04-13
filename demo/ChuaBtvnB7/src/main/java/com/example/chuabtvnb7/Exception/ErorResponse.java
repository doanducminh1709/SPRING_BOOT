package com.example.chuabtvnb7.Exception;

public class ErorResponse {
    private Integer status;
    private String message;

    public ErorResponse(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public ErorResponse() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
