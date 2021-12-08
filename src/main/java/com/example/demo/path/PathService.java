package com.example.demo.path;

import com.example.demo.region.Region;
import com.example.demo.region.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class PathService {
    private final PathRepository pathRepository;

    @Autowired
    public PathService(PathRepository pathRepository) {
        this.pathRepository = pathRepository;
    }

    public List<Path> getPaths() {
        return pathRepository.findAll();
    }

    public Path getPathById(Integer id) {
        Path path = pathRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "path with id " + id + "does not exist"));
        return path;

    }

    public Path addNewPath(Date date, BigDecimal originLat, BigDecimal originLon, BigDecimal destinationLat, BigDecimal destinationLon) {
        Path path = pathRepository.findByAttributes(date, originLat, originLon, destinationLat, destinationLon);
        if (path == null || path.getId() == null) {
            path = new Path();
            path.setDatetime(date);
            path.setOrigin_lat(originLat);
            path.setOrigin_lon(originLon);
            path.setDestination_lat(destinationLat);
            path.setDestination_lon(destinationLon);
            pathRepository.save(path);
        }
        return path;
    }
}
