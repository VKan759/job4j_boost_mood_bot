package ru.job4j.bmb.services;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import ru.job4j.bmb.model.User;
import ru.job4j.bmb.model.UserFakeRepository;

@Service
public class ReminderService {
    private TgRemoteService tgRemoteService;
    private UserFakeRepository userFakeRepository;

    public ReminderService(TgRemoteService tgRemoteService, UserFakeRepository userFakeRepository) {
        this.tgRemoteService = tgRemoteService;
        this.userFakeRepository = userFakeRepository;
    }

    @Scheduled(fixedRateString = "${remind.period}")
    private void ping() {
        for (User user : userFakeRepository.findAll()) {
            SendMessage message = new SendMessage();
            message.setText("ping");
            message.setChatId(user.getChatId());
            tgRemoteService.send(message);
        }
    }
}
