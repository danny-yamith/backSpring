package com.example.demo.region;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {
    private final RegionRepository regionRepository;

    @Autowired
    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public List<Region> getRegions() {
        return regionRepository.findAll();
    }

    public Region getRegionById(Integer id) {
        Region region = regionRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "region with id " + id + "does not exist"));
        return region;

    }

    public Region addNewRegion(String name) {
        Region region = regionRepository.findByName(name);
        if (region == null || region.getId() == null) {
            region = new Region();
            region.setName(name);
            regionRepository.save(region);
        }
        return region;
    }
}
