package com.example.demo.datasource;

import com.example.demo.region.Region;
import com.example.demo.region.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatasourceService {
    private final DatasourceRepository datasourceRepository;

    @Autowired
    public DatasourceService(DatasourceRepository datasourceRepository) {
        this.datasourceRepository = datasourceRepository;
    }

    public List<Datasource> getDatasources() {
        return datasourceRepository.findAll();
    }

    public Datasource getDatasourceById(Integer id) {
        Datasource datasource = datasourceRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "datasource with id " + id + "does not exist"));
        return datasource;

    }

    public Datasource addNewDatasource(String name) {
        Datasource datasource = datasourceRepository.findByName(name);
        if (datasource == null || datasource.getId() == null) {
            datasource = new Datasource();
            datasource.setName(name);
            datasourceRepository.save(datasource);
        }
        return datasource;
    }
}
