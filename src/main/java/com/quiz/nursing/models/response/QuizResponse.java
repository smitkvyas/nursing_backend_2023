package com.quiz.nursing.models.response;

import com.quiz.nursing.models.Question;
import com.quiz.nursing.models.Quiz;

import java.util.List;

public class QuizResponse {

    private Quiz quiz;
    private List<Question> questionList;

    public Quiz getQuiz() {
        return quiz;
    }

    public QuizResponse setQuiz(Quiz quiz) {
        this.quiz = quiz;
        return this;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public QuizResponse setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
        return this;
    }
}
