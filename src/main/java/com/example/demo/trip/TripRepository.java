package com.example.demo.trip;

import com.example.demo.utils.TripRegionDto;
import com.example.demo.utils.TripWeeklyDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Integer> {

    @Query(value = "SELECT new com.example.demo.utils.TripRegionDto(r.name, count(*)) FROM Trip t INNER JOIN t.region r GROUP BY r.name ")
    List<TripRegionDto> getPromTrips();

    @Query(name = "find_weekly_dto", nativeQuery = true)
    List<TripWeeklyDto> getWeekly(@Param("year") Integer year);
}
