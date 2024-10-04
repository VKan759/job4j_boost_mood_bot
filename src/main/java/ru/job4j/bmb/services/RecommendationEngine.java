package ru.job4j.bmb.services;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import ru.job4j.bmb.content.Content;
import ru.job4j.bmb.content.ContentProvider;

import java.util.List;
import java.util.Random;

public class RecommendationEngine implements ApplicationContextAware {
    private List<ContentProvider> contents;
    private static final Random RND = new Random(System.currentTimeMillis());

    public RecommendationEngine(List<ContentProvider> contents) {
        this.contents = contents;
    }

    public Content recommendFor(Long chatId, Long moodId) {
        var index = RND.nextInt(0, contents.size());
        return contents.get(index).byMood(chatId, moodId);
    }

    @PostConstruct
    public void init() {
        System.out.println("Bean RecommendationEngine is going through @PostConstruct init.");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Bean RecommendationEngine will be destroyed via @PreDestroy.");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}
