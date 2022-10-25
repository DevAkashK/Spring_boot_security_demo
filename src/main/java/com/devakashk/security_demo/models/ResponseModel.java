package com.devakashk.security_demo.models;

public class ResponseModel {
    private String message;
    private Object data;

    public ResponseModel(String message, Object data) {
        this.message = message;
        this.data = data;
    }

}
