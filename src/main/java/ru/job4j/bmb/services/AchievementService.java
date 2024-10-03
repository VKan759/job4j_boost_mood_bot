package ru.job4j.bmb.services;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class AchievementService {
    @PostConstruct
    public void init() {
        System.out.println("Bean AchievementService is going through @PostConstruct init.");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Bean AchievementService will be destroyed via @PreDestroy.");
    }
}
