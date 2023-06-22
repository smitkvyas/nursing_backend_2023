package com.quiz.nursing.services;

import com.quiz.nursing.models.Question;
import com.quiz.nursing.models.Quiz;
import com.quiz.nursing.models.response.QuizResponse;
import com.quiz.nursing.repos.QuizRepo;
import com.quiz.nursing.util.StatusResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizService {
    private final Logger LOG = LogManager.getLogger(QuizService.class);

    private final QuizRepo quizRepo;
    private final QuestionService questionService;

    private final int FREE_DAILY_QUIZ_TYPE = 1;

    private final int ENABLE_STATUS = 1;
    private final int DISABLE_STATUS = 0;

    public QuizService(QuestionService questionService, QuizRepo quizRepo) {
        this.questionService = questionService;
        this.quizRepo = quizRepo;
    }

    public Quiz getQuizById(Long quizId) {
        return null;
    }

    public Quiz createQuiz(Quiz quiz) {
        return null;
    }

    public Quiz updateQuiz(Long quizId, Quiz quiz) {
        return null;
    }

    public void deleteQuiz(Long quizId) {

    }

    @Scheduled(cron = "0 10 0 ? * *")
    public void createQuiz() {
        createQuiz(1L, 20);
    }

    public StatusResponse createQuiz(Long field, int count) {
        LOG.info("createQuiz() called with: field = [" + field + "], count = [" + count + "]");
        List<Question> questionFroQuiz = questionService.getQuestionFroQuiz(field, 20);

        if (questionFroQuiz != null && questionFroQuiz.size() == count) {
            Quiz savedQuiz = quizRepo.save(new Quiz()
                    .setActiveFrom(Timestamp.from(Instant.now())).setCreatedOn(Timestamp.from(Instant.now()))
                    .setActiveTill(Timestamp.from(LocalDate.now().plusYears(30).atStartOfDay().toInstant(ZoneOffset.UTC)))
                    .setDescription("Daily Quiz").setTitle("Daily Quiz")
                    .setType(FREE_DAILY_QUIZ_TYPE).setStatus(ENABLE_STATUS)
                    .setQuestionIds(questionFroQuiz.stream().map(q -> String.valueOf(q.getId())).collect(Collectors.joining(","))));

            questionFroQuiz.forEach(q -> questionService.updateQuestion(q.setLastAddedInQuiz(Timestamp.from(Instant.now()))));
            return new StatusResponse().setSuccess(savedQuiz);
        } else return new StatusResponse().setError("Not enough questions found to generate quiz");
    }

    public StatusResponse createQuiz(Long field, int count, Long date) {
        LOG.info("createQuiz() called with: field = [" + field + "], count = [" + count + "], date = [" + date + "]");
        List<Question> questionFroQuiz = questionService.getQuestionFroQuiz(field, 20);

        if (questionFroQuiz != null && questionFroQuiz.size() == count) {
            Quiz savedQuiz = quizRepo.save(new Quiz()
                    .setActiveFrom(Timestamp.from(Instant.ofEpochMilli(date))).setCreatedOn(Timestamp.from(Instant.now()))
                    .setActiveTill(Timestamp.from(LocalDate.now().plusYears(30).atStartOfDay().toInstant(ZoneOffset.UTC)))
                    .setDescription("Daily Quiz").setTitle("Daily Quiz")
                    .setType(FREE_DAILY_QUIZ_TYPE).setStatus(ENABLE_STATUS)
                    .setQuestionIds(questionFroQuiz.stream().map(q -> String.valueOf(q.getId())).collect(Collectors.joining(","))));

            questionFroQuiz.forEach(q -> questionService.updateQuestion(q.setLastAddedInQuiz(Timestamp.from(Instant.now()))));
            return new StatusResponse().setSuccess(savedQuiz);
        } else return new StatusResponse().setError("Not enough questions found to generate quiz");
    }

    public StatusResponse getActiveFreeDailyQuiz(Long date) {
        LOG.info("getActiveFreeDailyQuiz() called with: date = [" + date + "]");

        List<QuizResponse> quizResponses = new ArrayList<>();
        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date), ZoneOffset.UTC);
        LocalDateTime dayStart = dateTime.toLocalDate().atStartOfDay();
        LocalDateTime dayEnd = dayStart.plus(1, ChronoUnit.DAYS).minus(1, ChronoUnit.SECONDS);
        Timestamp startTimestamp = Timestamp.valueOf(dayStart);
        Timestamp endTimestamp = Timestamp.valueOf(dayEnd);

        ArrayList<Quiz> quizzes = quizRepo.findByActiveFromBetweenAndTypeAndStatus(startTimestamp, endTimestamp, FREE_DAILY_QUIZ_TYPE, ENABLE_STATUS);
        if (quizzes != null && quizzes.size() > 0) {
            for (Quiz quiz : quizzes) {
                List<Question> questions = questionService.getQuestionById(Arrays.asList(quiz.getQuestionIds().split(",")));
                quizResponses.add(new QuizResponse().setQuiz(quiz).setQuestionList(questions));
            }
            return new StatusResponse().setSuccess(quizResponses);
        } else return new StatusResponse().setError("Quiz not found");
    }
}
