package com.sarvoftware.telegram.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class CacheConfig {

    @Bean(name = "subscribers-ids")
    public List<String> clientIds() {
        return new ArrayList<>();
    }

}
