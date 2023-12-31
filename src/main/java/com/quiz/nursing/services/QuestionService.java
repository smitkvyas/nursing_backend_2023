package com.quiz.nursing.services;

import com.quiz.nursing.models.Question;
import com.quiz.nursing.repos.QuestionRepo;
import com.quiz.nursing.util.StatusResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    private static final Logger LOG = LogManager.getLogger(QuestionService.class);

    private final QuestionRepo questionRepo;

    //<editor-fold desc="Statuses">
    public final Long STATUS_ENABLE = 1L;
    public final Long STATUS_DISABLE = 0L;
    //</editor-fold>

    //<editor-fold desc="Languages">
    public final Long LANGUAGE_ENGLISH = 1L;
    //</editor-fold>

    //<editor-fold desc="Create By">
    public final Long SYSTEM = 1L;

    public QuestionService(QuestionRepo questionRepo) {
        this.questionRepo = questionRepo;
    }

    //</editor-fold>

    private Question generateQuestion(String question, String optionA, String optionB, String optionC, String optionD, String answer,
                                      Long field, Long subject, Long topic, Long status, Long language) {
        LOG.info("generateQuestion() called with: question = [" + question + "], optionA = [" + optionA + "], " +
                "optionB = [" + optionB + "], optionC = [" + optionC + "], optionD = [" + optionD + "], " +
                "answer = [" + answer + "], field = [" + field + "], subject = [" + subject + "], " +
                "topic = [" + topic + "], status = [" + status + "], language = [" + language + "]");
        return new Question()
                .setCreatedOn(Timestamp.valueOf(LocalDateTime.now()))
                .setUpdatedOn(Timestamp.valueOf(LocalDateTime.now()))
                .setQuestion(question).setOptionA(optionA).setOptionB(optionB).setOptionC(optionC).setOptionD(optionD).setAnswer(answer)
                .setSubject(subject).setTopic(topic).setField(field)
                .setCreatedBy(SYSTEM).setStatus(status).setLanguage(language);
    }

    public StatusResponse saveNewQuestion(String question, String optionA, String optionB,
                                          String optionC, String optionD, String answer, Long field) {
        LOG.info("saveNewQuestion() called with: question = [" + question + "], optionA = [" + optionA + "], optionB = " +
                "[" + optionB + "], optionC = [" + optionC + "], optionD = [" + optionD + "], answer = [" + answer + "], field = [" + field + "]");
        return saveNewQuestion(question, optionA, optionB, optionC, optionD, answer, field, null, null);
    }

    public StatusResponse saveNewQuestion(String question, String optionA, String optionB,
                                          String optionC, String optionD, String answer, Long field, Long subject) {
        LOG.info("saveNewQuestion() called with: question = [" + question + "], optionA = [" + optionA + "], optionB =" +
                " [" + optionB + "], optionC = [" + optionC + "], optionD = [" + optionD + "], answer = [" + answer + "]," +
                " field = [" + field + "], subject = [" + subject + "]");
        return saveNewQuestion(question, optionA, optionB, optionC, optionD, answer, field, subject, null);
    }

    public StatusResponse saveNewQuestion(String question, String optionA, String optionB,
                                          String optionC, String optionD, String answer, Long field, Long subject, Long topic) {
        LOG.info("saveNewQuestion() called with: question = [" + question + "], optionA = [" + optionA + "], optionB =" +
                " [" + optionB + "], optionC = [" + optionC + "], optionD = [" + optionD + "], answer = [" + answer + "], " +
                "field = [" + field + "], subject = [" + subject + "], topic = [" + topic + "]");
        Question questionObject = generateQuestion(question, optionA, optionB, optionC, optionD, answer,
                field, subject, topic, STATUS_ENABLE, LANGUAGE_ENGLISH);

        try {
            Question savedQuestion = questionRepo.save(questionObject);
            return new StatusResponse().setSuccess(savedQuestion);
        } catch (Exception e) {
            e.printStackTrace();
            return new StatusResponse().setError(e.getMessage());
        }
    }

    public List<Question> getQuestionFor(Long field) {
        LOG.info("getQuestionFor() called with: field = [" + field + "]");
        return questionRepo.findByFieldAndStatusAndLanguage(field, STATUS_ENABLE, LANGUAGE_ENGLISH);
    }


    public List<Question> getQuestionFroQuiz(Long field, int count) {
        LOG.info("getQuestionFroQuiz() called with: field = [" + field + "], count = [" + count + "]");

        Instant endDate = Instant.now().minus(90, ChronoUnit.DAYS);
        return questionRepo.findByFieldAndLastAddedInQuizBeforeOrLastAddedInQuizIsNull(field, Timestamp.from(endDate), PageRequest.of(0, count));
    }

    public Question updateQuestion(Question question) {
        LOG.info("updateQuestion() called with: question = [" + question + "]");
        return questionRepo.save(question);
    }

    public List<Question> getQuestionById(List<String> questionsIds) {
        LOG.info("getQuestionById() called with: questionsIds = [" + questionsIds + "]");
        List<Question> questions = new ArrayList<>();
        questionsIds.forEach(id -> {
            Optional<Question> question = questionRepo.findById(Long.valueOf(id));
            question.ifPresent(questions::add);
        });
        return questions;
    }
}
