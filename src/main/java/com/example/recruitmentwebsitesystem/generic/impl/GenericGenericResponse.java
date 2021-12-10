package com.example.recruitmentwebsitesystem.generic.impl;

import org.springframework.http.HttpStatus;

import java.util.Date;

public class GenericGenericResponse<T> {
    private Date timestamp;
    private HttpStatus status;
    private String message;
    T data;
    public Date getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
    public HttpStatus getStatus() {
        return status;
    }
    public void setStatus(HttpStatus status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public GenericGenericResponse() {
        super();
        // TODO Auto-generated constructor stub
    }
    public GenericGenericResponse(Date timestamp, HttpStatus status, String message, T data) {
        super();
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
