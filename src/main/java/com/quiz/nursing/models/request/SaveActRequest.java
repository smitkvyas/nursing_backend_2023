package com.quiz.nursing.models.request;

public class SaveActRequest {

    private String act,year;

    public String getAct() {
        return act;
    }

    public SaveActRequest setAct(String act) {
        this.act = act;
        return this;
    }

    public String getYear() {
        return year;
    }

    public SaveActRequest setYear(String year) {
        this.year = year;
        return this;
    }
}
