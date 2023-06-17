package com.quiz.nursing.services;

import com.quiz.nursing.models.Question;
import com.quiz.nursing.repos.QuestionRepo;
import com.quiz.nursing.util.StatusResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class QuestionService {

    private static final Logger logger = LogManager.getLogger(QuestionService.class);

    @Autowired
    private QuestionRepo questionRepo;

    //<editor-fold desc="Statuses">
    public final Long STATUS_ENABLE = 1L;
    public final Long STATUS_DISABLE = 0L;
    //</editor-fold>

    //<editor-fold desc="Languages">
    public final Long LANGUAGE_ENGLISH = 1L;
    //</editor-fold>

    //<editor-fold desc="Create By">
    public final Long SYSTEM = 1L;

    //</editor-fold>
    private Question generateQuestion(String question, String optionA, String optionB, String optionC, String optionD, String answer,
                                      Long field, Long subject, Long topic, Long status, Long language) {
        return new Question()
                .setCreatedOn(Timestamp.valueOf(LocalDateTime.now()))
                .setUpdatedOn(Timestamp.valueOf(LocalDateTime.now()))
                .setQuestion(question).setOptionA(optionA).setOptionB(optionB).setOptionC(optionC).setOptionD(optionD).setAnswer(answer)
                .setSubject(subject).setTopic(topic).setField(field)
                .setCreatedBy(SYSTEM).setStatus(status).setLanguage(language);
    }

    public StatusResponse saveNewQuestion(String question, String optionA, String optionB,
                                          String optionC, String optionD, String answer, Long field) {
        return saveNewQuestion(question, optionA, optionB, optionC, optionD, answer, field, null, null);
    }

    public StatusResponse saveNewQuestion(String question, String optionA, String optionB,
                                          String optionC, String optionD, String answer, Long field, Long subject) {
        return saveNewQuestion(question, optionA, optionB, optionC, optionD, answer, field, subject, null);
    }

    public StatusResponse saveNewQuestion(String question, String optionA, String optionB,
                                          String optionC, String optionD, String answer, Long field, Long subject, Long topic) {
        Question questionObject = generateQuestion(question, optionA, optionB, optionC, optionD, answer,
                field, subject, topic, STATUS_ENABLE, LANGUAGE_ENGLISH);

        Question savedQuestion = questionRepo.save(questionObject);
        return new StatusResponse().setSuccess(savedQuestion);
    }

    public List<Question> getQuestionFor(Long field) {
        return questionRepo.findByFieldAndStatusAndLanguage(field,STATUS_ENABLE,LANGUAGE_ENGLISH);
    }

}
