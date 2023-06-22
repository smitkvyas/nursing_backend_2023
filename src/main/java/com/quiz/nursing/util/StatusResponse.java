package com.quiz.nursing.util;

public class StatusResponse {


    private boolean isSuccess;
    private Object object;
    private String message;

    public boolean isSuccess() {
        return isSuccess;
    }

    public StatusResponse setSuccess(boolean success) {
        isSuccess = success;
        return this;
    }

    public Object getObject() {
        return object;
    }

    public StatusResponse setObject(Object object) {
        this.object = object;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public StatusResponse setMessage(String message) {
        this.message = message;
        return this;
    }

    @Override
    public String toString() {
        return "StatusResponse{" +
                "isSuccess=" + isSuccess +
                ", object=" + (object != null ? object.toString() : object) +
                ", errorMessage='" + message + '\'' +
                '}';
    }

    public StatusResponse setSuccess(Object object) {
        this.isSuccess = true;
        this.object = object;
        this.message = "";
        return this;
    }

    public StatusResponse setError(String message) {
        this.isSuccess = false;
        this.message = message;
        return this;
    }
}