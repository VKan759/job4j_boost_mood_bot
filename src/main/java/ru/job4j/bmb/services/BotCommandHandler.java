package ru.job4j.bmb.services;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import ru.job4j.bmb.content.Content;

@Service
public class BotCommandHandler implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    @PostConstruct
    public void init() {
        System.out.println("Bean BotCommandHandler is going through @PostConstruct init.");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Bean BotCommandHandler will be destroyed via @PreDestroy.");
    }

    void receive(Content content) {
        System.out.println(content);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        System.out.println("ApplicationContext set in BotCommandHandler");

    }

    public void printBeanName() {
        String[] names = applicationContext.getBeanDefinitionNames();
        System.out.println("Beans in ApplicationContext");
        for (String name : names) {
            System.out.println(name);
        }
    }
}