package ru.job4j.bmb.services;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class RecommendationEngine {
    @PostConstruct
    public void init() {
        System.out.println("Bean RecommendationEngine is going through @PostConstruct init.");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Bean RecommendationEngine will be destroyed via @PreDestroy.");
    }
}
