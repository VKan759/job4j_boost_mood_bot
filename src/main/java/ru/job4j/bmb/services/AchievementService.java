package ru.job4j.bmb.services;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class AchievementService implements ApplicationContextAware {
    private ApplicationContext context;

    @PostConstruct
    public void init() {
        System.out.println("Bean AchievementService is going through @PostConstruct init.");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Bean AchievementService will be destroyed via @PreDestroy.");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
        System.out.println("ApplicationContext set in AchievementService");
    }

    public void printBeanName() {
        String[] names = context.getBeanDefinitionNames();
        System.out.println("Beans in ApplicationContext");
        for (String name : names) {
            System.out.println(name);
        }
    }
}
