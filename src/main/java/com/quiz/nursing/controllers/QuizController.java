package com.quiz.nursing.controllers;

import com.quiz.nursing.models.Quiz;
import com.quiz.nursing.services.QuizService;
import com.quiz.nursing.util.StatusResponse;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {

    private final Logger LOG = LogManager.getLogger(QuizController.class);

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/free/daily-quiz")
    @ApiOperation("Get quiz by ID")
    public ResponseEntity<Object> getQuizById(@RequestParam Long date) {
        LOG.info("getQuizById() called with: date = [" + date + "]");
        StatusResponse statusResponse = quizService.getActiveFreeDailyQuiz(date);
        if (statusResponse.isSuccess()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(statusResponse.getObject());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(statusResponse.getMessage());
        }
    }

    @PostMapping("/free/daily-quiz")
    @ApiOperation("Create a new free daily-quiz")
    public ResponseEntity<Object> createFreeDailyQuiz(@RequestParam Long field, @RequestParam int noOfQuestion) {
        LOG.info("createFreeDailyQuiz() called with: field = [" + field + "], noOfQuestion = [" + noOfQuestion + "]");
        StatusResponse statusResponse = quizService.createQuiz(field, noOfQuestion);
        if (statusResponse.isSuccess()) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Created");
        } else {
            return ResponseEntity.internalServerError().body(statusResponse.getMessage());
        }
    }

    @PostMapping("/free/daily-quiz/forDay")
    @ApiOperation("Create a new free daily-quiz")
    public ResponseEntity<Object> createFreeDailyQuizFor(@RequestParam Long field, @RequestParam int noOfQuestion, @RequestParam Long date) {
        LOG.info("createFreeDailyQuizFor() called with: field = [" + field + "], noOfQuestion = [" + noOfQuestion + "], date = [" + date + "]");

        StatusResponse statusResponse = quizService.createQuiz(field, noOfQuestion, date);
        if (statusResponse.isSuccess()) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Created");
        } else {
            return ResponseEntity.internalServerError().body(statusResponse.getMessage());
        }
    }

    @PutMapping("/{quizId}")
    @ApiOperation("Update an existing quiz")
    public ResponseEntity<Quiz> updateQuiz(@PathVariable("quizId") Long quizId, @RequestBody Quiz quiz) {
        Quiz updatedQuiz = quizService.updateQuiz(quizId, quiz);
        return ResponseEntity.ok(updatedQuiz);
    }

    @DeleteMapping("/{quizId}")
    @ApiOperation("Delete a quiz")
    public ResponseEntity<Void> deleteQuiz(@PathVariable("quizId") Long quizId) {
        quizService.deleteQuiz(quizId);
        return ResponseEntity.noContent().build();
    }
}
