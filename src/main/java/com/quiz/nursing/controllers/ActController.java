package com.quiz.nursing.controllers;

import com.quiz.nursing.models.request.SaveActRequest;
import com.quiz.nursing.services.NursingActsService;
import com.quiz.nursing.util.StatusResponse;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/acts/nursing")
public class ActController {


    private final Logger LOG = LogManager.getLogger(ActController.class);
    private final NursingActsService nursingActsService;

    public ActController(NursingActsService nursingActsService) {
        this.nursingActsService = nursingActsService;
    }

    @GetMapping("/active")
    @ApiOperation("Get active nursing acts")
    public ResponseEntity<Object> getActiveActs() {
        LOG.info("getActiveActs() called");
        return ResponseEntity.ok(nursingActsService.getActiveActs());
    }

    @PostMapping
    @ApiOperation("Add new nursing act")
    public ResponseEntity<String> saveAct(@RequestBody SaveActRequest saveActRequest) {
        LOG.info("saveAct() called with: saveActRequest = [" + saveActRequest + "]");
        StatusResponse statusResponse = nursingActsService.saveAct(saveActRequest.getAct(), saveActRequest.getYear());
        if (statusResponse.isSuccess()) {
            return ResponseEntity.ok("success");
        } else {
            return ResponseEntity.internalServerError().body(statusResponse.getMessage());
        }
    }

}
