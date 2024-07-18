package com.phom.thuchanhtonghop.entity;

public class ErrorResponse {
    private int status;
    private String message;
    private double timestamp;
    public ErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
        timestamp = System.currentTimeMillis();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public double getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(double timestamp) {
        this.timestamp = timestamp;
    }
}
