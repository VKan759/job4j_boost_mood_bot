package ru.job4j.bmb.content;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.InputFile;

import java.io.File;

@Component
public class ContentProviderAudio implements ContentProvider {

    @Override
    public Content byMood(Long chatId, Long moodId) {
        Content content = new Content(chatId);
        var audio = new File("./audio/music.mp3");
        content.setAudio(new InputFile(audio));
        return content;
    }
}
