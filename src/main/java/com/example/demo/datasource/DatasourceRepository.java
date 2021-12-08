package com.example.demo.datasource;

import com.example.demo.region.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DatasourceRepository extends JpaRepository<Datasource, Integer> {

    @Query("SELECT r FROM Datasource r WHERE r.name = ?1")
    Datasource findByName(String name);

}
