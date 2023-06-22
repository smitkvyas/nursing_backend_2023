package com.quiz.nursing.services;

import com.quiz.nursing.models.NursingActs;
import com.quiz.nursing.repos.NursingActRepo;
import com.quiz.nursing.util.StatusResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;

@Service
public class NursingActsService {

    private final Logger LOG = LogManager.getLogger(NursingActsService.class);
    private final NursingActRepo nursingActRepo;
    private final int ENABLE_STATUS = 1;

    public NursingActsService(NursingActRepo nursingActRepo) {
        this.nursingActRepo = nursingActRepo;
    }

    public ArrayList<NursingActs> getActiveActs() {
        LOG.info("getActiveActs() called");
        return nursingActRepo.findAllByStatus(ENABLE_STATUS);
    }

    public StatusResponse saveAct(String act, String year) {
        LOG.info("saveAct() called with: act = [" + act + "], year = [" + year + "]");
        try {
            NursingActs savedAct = nursingActRepo.save(new NursingActs().setYear(year).setAct(act).setStatus(ENABLE_STATUS)
                    .setCreatedOn(Timestamp.from(Instant.now())).setUpdatedOn(Timestamp.from(Instant.now())));
            return new StatusResponse().setSuccess(savedAct);
        } catch (Exception e) {
            e.printStackTrace();
            return new StatusResponse().setError(e.getMessage());
        }
    }
}
