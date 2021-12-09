package com.example.demo.utils;

public class TripRegionDto {
    private String regionName;
    private Long regionTotal;

    public TripRegionDto() {
    }

    public TripRegionDto(String regionName, Long regionTotal) {
        this.regionName = regionName;
        this.regionTotal = regionTotal;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public Long getRegionTotal() {
        return regionTotal;
    }

    public void setRegionTotal(Long regionTotal) {
        this.regionTotal = regionTotal;
    }
}
