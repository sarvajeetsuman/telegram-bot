package com.sarvoftware.telegram.web.service;

import com.sarvoftware.telegram.web.bot.TelegramBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TelegramMessageService {

    @Autowired
    TelegramBot telegramBot;

    public void send(String text) {
        telegramBot.send(text);

    }

}
