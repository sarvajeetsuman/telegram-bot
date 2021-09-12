package com.sarvoftware.telegram.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.sarvoftware.telegram.model",
		"com.sarvoftware.telegram.persistence.*",
		"com.sarvoftware.telegram.web.*"})
@EntityScan(value = "com.sarvoftware.telegram.persistence.entities")
@EnableJpaRepositories(basePackages= {"com.sarvoftware.telegram.persistence.repositories"})
public class TelegramWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(TelegramWebApplication.class, args);
	}

}
