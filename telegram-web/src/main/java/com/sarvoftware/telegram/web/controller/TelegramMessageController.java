package com.sarvoftware.telegram.web.controller;

import com.sarvoftware.telegram.model.TelegramMessage;
import com.sarvoftware.telegram.web.service.TelegramMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/telegram")
public class TelegramMessageController {

    @Autowired
    TelegramMessageService telegramMessageService;

    @PostMapping(value = "")
    public void send(@RequestBody TelegramMessage telegramMessage) {
        telegramMessageService.send(telegramMessage.getMessage());
    }

}
