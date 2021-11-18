package com.example.demo.portfolio;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;


@Configuration
public class PortfolioConfig {
    @Bean
    CommandLineRunner commandLineRunner(
            PortfolioRepository repository){
        return args -> {
            Portfolio portfolio1 = new Portfolio(
                    "have extensive experience as an IT Project Manager and in Software Development.",
                    "https://twitter.com/Qualisys_/photo",
                    "https://twitter.com/Qualisys_",
                    "test Zemoga",
                    null,
                    "experience_summary",
                    "Pascuaza Ortiz",
                    "Danny Yamith",
                    "twitter_user_id",
                    null
            );
            Portfolio portfolio2 = new Portfolio(
                    "prueba2",
                    "https://twitter.com/Qualisys_/photo",
                    "https://twitter.com/Qualisys_",
                    "prueba",
                    null,
                    "experience_summary",
                    "Ortiz",
                    "Jose",
                    "twitter_user_id",
                    null
            );
            //Arrays.asList instead of List.of in prior Java 9
            repository.saveAll(
                    Arrays.asList(portfolio1,portfolio2)
            );
        };
    }
}
