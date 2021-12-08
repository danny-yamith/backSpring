package com.example.demo.path;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;

@Repository
public interface PathRepository extends JpaRepository<Path, Integer> {

    @Query("SELECT r FROM Path r WHERE r.datetime = ?1 and r.origin_lat = ?2 and r.origin_lon = ?3 and r.destination_lat = ?4 and r.destination_lon = ?5 ")
    Path findByAttributes(Date date, BigDecimal originLat, BigDecimal originLon, BigDecimal destinationLat, BigDecimal destinationLon);

}
