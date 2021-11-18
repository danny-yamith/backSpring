package com.example.demo.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
class PortfolioRepositoryTest {

    @Autowired
    PortfolioRepository underTest;

    @Test
    void itShouldIfExistPortfolioByNames() {
        //given
        String names = "Danny Yamith";
        Portfolio portfolio = new Portfolio(
                "have extensive experience as an IT Project Manager and in Software Development.",
                "https://twitter.com/Qualisys_/photo",
                "https://twitter.com/Qualisys_",
                "test Zemoga",
                null,
                "experience_summary",
                "Figueroa",
                names,
                "twitter_user_id",
                null
        );
        underTest.save(portfolio);
        //when

        Boolean exists=underTest.findPortfolioByNames(names);
        //then

        assertThat(exists).isTrue();
    }
}