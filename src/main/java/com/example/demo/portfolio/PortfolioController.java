package com.example.demo.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import twitter4j.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path="api/v1/portfolio")
public class PortfolioController {
    private final PortfolioService portfolioService;
    private final PortfolioRepository portfolioRepository;

    //injection
    @Autowired
    public PortfolioController(PortfolioService portfolioService,PortfolioRepository portfolioRepository ) {
        this.portfolioService = portfolioService;
        this.portfolioRepository = portfolioRepository;
    }

    // get all portfolios
    @GetMapping
    public List<Portfolio> getPortfolios() {
        return portfolioService.getPortfolios(1);
    }

    /* create portfolio rest api*/
    @PostMapping
    public void registerNewPortfolio(@RequestBody Portfolio portfolio){

        portfolioService.addNewPortfolio(portfolio);
    }

    //update portfolio rest api
    @PutMapping
    public void updatePortfolio(@RequestBody Portfolio portfolio) {
        portfolioService.updatePortfolio(portfolio.getIdportfolio(), portfolio.getDescription(), portfolio.getNames(), portfolio.getLast_names());
    }

    @GetMapping
    @RequestMapping(path="/getTimeLines")
    public ResponseList<Status> getTimeLines(@Param("user") String user) throws TwitterException {
        Twitter twitter = TwitterFactory.getSingleton();
        ResponseList<Status> statuses = twitter.getUserTimeline(user);
        return statuses;
    }
}
