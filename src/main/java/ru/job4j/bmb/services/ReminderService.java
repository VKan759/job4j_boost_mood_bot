package ru.job4j.bmb.services;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ReminderService implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    @PostConstruct
    public void init() {
        System.out.println("Bean ReminderService is going through @PostConstruct init.");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Bean ReminderService will be destroyed via @PreDestroy.");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        System.out.println("ApplicationContext set in ReminderService");
    }

    public void printBeanNames() {
        String[] names = applicationContext.getBeanDefinitionNames();
        System.out.println("Beans in ApplicationContext:");
        for (String name : names) {
            System.out.println(name);
        }
    }
}
