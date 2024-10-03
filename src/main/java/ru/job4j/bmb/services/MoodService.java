package ru.job4j.bmb.services;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class MoodService {
    @PostConstruct
    public void init() {
        System.out.println("Bean MoodService is going through @PostConstruct init.");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Bean MoodService will be destroyed via @PreDestroy.");
    }
}
