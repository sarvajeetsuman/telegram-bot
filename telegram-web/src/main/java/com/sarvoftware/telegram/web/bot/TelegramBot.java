package com.sarvoftware.telegram.web.bot;

import com.sarvoftware.telegram.web.constants.PropertyConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

@Component
public class TelegramBot extends TelegramLongPollingBot {

    @Autowired
    @Qualifier(value = "subscribers-ids")
    List<String> subscribersIds;

    @Value("${" + PropertyConstants.TELEGRAM_API +"}")
    private String telegramApi;

    @Value("${" + PropertyConstants.TELEGRAM_NAME + "}")
    private String telegramName;

    @Override
    public String getBotUsername() {
        return telegramName;
    }

    @Override
    public String getBotToken() {
        return telegramApi;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            subscribersIds.add(update.getMessage().getChatId().toString());
        }
    }

    public void send(String text) {
        subscribersIds.stream().forEach(subscribersId -> {
            SendMessage message = new SendMessage();
            message.setChatId(subscribersId);
            message.setText(text);
            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        });
    }
}
