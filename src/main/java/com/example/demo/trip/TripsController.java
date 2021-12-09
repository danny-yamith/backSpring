package com.example.demo.trip;

import com.example.demo.utils.TripDto;
import com.example.demo.utils.TripFileDto;
import com.example.demo.utils.TripRegionDto;
import com.example.demo.utils.TripWeeklyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path="api/v1/trip")
public class TripsController {
    private final TripService tripService;
    private final TripRepository tripRepository;

    @Autowired
    public TripsController(TripService tripService, TripRepository tripRepository ) {
        this.tripRepository = tripRepository;
        this.tripService = tripService;
    }

    @PostMapping
    @RequestMapping(path="/processTrips")
    public String processTrips(@ModelAttribute TripFileDto tripFileDto) throws Exception {
        return this.tripService.processFile(tripFileDto.getFile());
    }

    @GetMapping
    @RequestMapping(path="/getPromTrips")
    public List<TripRegionDto> getPromTrips() throws Exception {
        return this.tripService.getPromTrips();
    }

    @GetMapping
    @RequestMapping(path="/getWeekly")
    public List<TripWeeklyDto> getWeekly(@Param("year") Integer year) throws Exception {
        return this.tripService.getWeekly(year);
    }
}
