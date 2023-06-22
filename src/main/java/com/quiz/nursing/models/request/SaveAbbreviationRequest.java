package com.quiz.nursing.models.request;

public class SaveAbbreviationRequest {

    private String shortForm,fullForm;

    public String getShortForm() {
        return shortForm;
    }

    public SaveAbbreviationRequest setShortForm(String shortForm) {
        this.shortForm = shortForm;
        return this;
    }

    public String getFullForm() {
        return fullForm;
    }

    public SaveAbbreviationRequest setFullForm(String fullForm) {
        this.fullForm = fullForm;
        return this;
    }
}
