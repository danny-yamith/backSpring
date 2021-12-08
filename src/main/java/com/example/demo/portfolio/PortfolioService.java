package com.example.demo.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PortfolioService {
    private final PortfolioRepository portfolioRepository;

    @Autowired
    public PortfolioService(PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;
    }

    public List<Portfolio> getPortfolios(Integer idportfolio) {
        return portfolioRepository.findAllById(Collections.singleton(idportfolio));
    }

    public Portfolio getPortfolioById(Integer idportfolio) {
        Portfolio portfolio = portfolioRepository.findById(idportfolio)
                .orElseThrow(() -> new IllegalStateException(
                        "portfolio with id " + idportfolio + "does not exist"));
        return portfolioRepository.getById(idportfolio);

    }

    public void addNewPortfolio(Portfolio portfolio) {
        Boolean exits = portfolioRepository.findPortfolioByNames(portfolio.getNames());
        if (exits) {
            throw new IllegalStateException("names taken");
        }
        portfolioRepository.save(portfolio);
    }

    public void deletePortfolio(Integer idportfolio) {
        Portfolio portfolio = portfolioRepository.findById(idportfolio)
                .orElseThrow(() -> new IllegalStateException(
                        "portfolio with id " + idportfolio + "does not exist"));
        portfolioRepository.delete(portfolio);

    }

    public void updatePortfolio(Integer idportfolio,
                                String description,
                                String names,
                                String last_names) {
        Portfolio portfolio = portfolioRepository.findById(idportfolio)
                .orElseThrow(() -> new IllegalStateException(
                        "portfolio with id " + idportfolio + "does not exist"));
        if (description != null &&
                description.length() > 0 &&
                !Objects.equals(portfolio.getDescription(), description)
        ) {
            portfolio.setDescription(description);

        }
        if (names != null &&
                names.length() > 0 &&
                !Objects.equals(portfolio.getNames(), names)
        ) {
            Boolean exits = portfolioRepository.findPortfolioByNames(names);
            if (exits) {
                throw new IllegalStateException("names taken");
            }
            portfolio.setNames(names);

        }
        if (last_names != null &&
                last_names.length() > 0 &&
                !Objects.equals(portfolio.getLast_names(), last_names)
        ) {
            portfolio.setLast_names(last_names);

        }

        portfolioRepository.save(portfolio);

    }
}
