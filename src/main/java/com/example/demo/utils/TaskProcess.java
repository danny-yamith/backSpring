package com.example.demo.utils;

import com.example.demo.trip.TripService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class TaskProcess {

    @Autowired
    private TripService tripService;

    private static final Logger log = LoggerFactory.getLogger(TaskProcess.class);
    private static final String PATH_FILE = "src/main/resources/trips.csv";

    @Scheduled(fixedRate = 5000000)
    public void taskProcess() {
        try {
            File file = new File(PATH_FILE);
            String response = tripService.processTrips(file.getAbsolutePath(), false);
            log.info(response);
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
    }
}
