package com.quiz.nursing.controllers;

import com.quiz.nursing.models.request.SaveAbbreviationRequest;
import com.quiz.nursing.models.request.SaveActRequest;
import com.quiz.nursing.services.NursingAbbreviationService;
import com.quiz.nursing.services.NursingActsService;
import com.quiz.nursing.util.StatusResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/abbreviations")
public class AbbreviationController {


    private final Logger LOG = LogManager.getLogger(AbbreviationController.class);
    private final NursingAbbreviationService nursingAbbreviationService;

    public AbbreviationController(NursingAbbreviationService nursingAbbreviationService) {
        this.nursingAbbreviationService = nursingAbbreviationService;
    }

    @GetMapping("/active")
    public ResponseEntity<Object> getActiveAbbreviations() {
        LOG.info("getActiveAbbreviations() called");
        return ResponseEntity.ok(nursingAbbreviationService.getActiveAbbreviations());
    }

    @PostMapping
    public ResponseEntity<String> saveAbbreviation(@RequestBody SaveAbbreviationRequest saveAbbreviationRequest) {
        LOG.info("saveAbbreviation() called with: saveAbbreviationRequest = [" + saveAbbreviationRequest + "]");
        StatusResponse statusResponse = nursingAbbreviationService.saveAbbreviation(saveAbbreviationRequest.getShortForm(), saveAbbreviationRequest.getFullForm());
        if (statusResponse.isSuccess()) {
            return ResponseEntity.ok("success");
        } else {
            return ResponseEntity.internalServerError().body(statusResponse.getMessage());
        }
    }

}
