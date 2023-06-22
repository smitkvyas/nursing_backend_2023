package com.quiz.nursing.controllers;

import com.quiz.nursing.models.request.QuestionRequest;
import com.quiz.nursing.services.QuestionService;
import com.quiz.nursing.util.StatusResponse;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    private final Logger LOG = LogManager.getLogger(QuestionController.class);

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping()
    @ApiOperation("Save new question")
    public ResponseEntity<String> saveNewQuestion(@RequestBody QuestionRequest questionRequest, @RequestParam Long field) {
        LOG.info("saveNewQuestion() called with: questionRequest = [" + questionRequest + "], field = [" + field + "]");

        StatusResponse statusResponse = questionService.saveNewQuestion(questionRequest.getQuestion(),
                questionRequest.getOptionA(), questionRequest.getOptionB(), questionRequest.getOptionC(),
                questionRequest.getOptionD(), questionRequest.getAnswer(), field);
        if (statusResponse.isSuccess()) {
            return ResponseEntity.ok("success");
        } else {
            return ResponseEntity.internalServerError().body(statusResponse.getMessage());
        }
    }
}
