package com.example.demo.utils;

import java.io.Serializable;

public class TripWeeklyDto implements Serializable {
    private String name_region;
    private Long count_week;

    public TripWeeklyDto() {
    }

    public TripWeeklyDto(String name_region, Long count_week) {
        this.name_region = name_region;
        this.count_week = count_week;
    }

    public String getName_region() {
        return name_region;
    }

    public void setName_region(String name_region) {
        this.name_region = name_region;
    }

    public Long getCount_week() {
        return count_week;
    }

    public void setCount_week(Long count_week) {
        this.count_week = count_week;
    }
}
