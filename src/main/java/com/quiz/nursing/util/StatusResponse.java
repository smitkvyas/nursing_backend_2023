package com.quiz.nursing.util;

public class StatusResponse {


    private boolean isSuccess;
    private Object object;
    private String errorMessage;

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

    public String getErrorMessage() {
        return errorMessage;
    }

    public StatusResponse setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }

    @Override
    public String toString() {
        return "StatusResponse{" +
                "isSuccess=" + isSuccess +
                ", object=" + (object != null ? object.toString() : object) +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }

    public StatusResponse setSuccess(Object object) {
        this.isSuccess = true;
        this.object = object;
        this.errorMessage = "";
        return this;
    }

    public StatusResponse setError(String message) {
        this.isSuccess = false;
        this.errorMessage = message;
        return this;
    }
}