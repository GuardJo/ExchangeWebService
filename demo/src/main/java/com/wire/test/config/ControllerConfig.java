package com.wire.test.config;

import com.wire.test.controller.ExchangeController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfig {
    @Bean
    public ExchangeController exchangeController() {
        ExchangeController exchangeController = new ExchangeController();
        return exchangeController;
    }
}
