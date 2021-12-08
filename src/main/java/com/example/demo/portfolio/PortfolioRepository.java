package com.example.demo.portfolio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PortfolioRepository
        extends JpaRepository <Portfolio,Integer> {

    @Query("SELECT COUNT(p)>0 FROM Portfolio p WHERE p.names = ?1")
    Boolean findPortfolioByNames(String names);
}
