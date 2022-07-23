package com.timal1.spring.web.cart.configs;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.util.concurrent.TimeUnit;

@Configuration
public class AppConfig {

    @Value("${integration.core-service.url}")
    private String productServiceUrl;

    @Bean
    public WebClient productServiceWebClient() {
        HttpClient httpClient = HttpClient
                .create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 2000)
                .doOnConnected(connection -> {
                    connection.addHandlerLast(new ReadTimeoutHandler(10000, TimeUnit.MILLISECONDS));
                    connection.addHandlerLast(new WriteTimeoutHandler(5000, TimeUnit.MILLISECONDS));
                });

        return WebClient
                .builder()
                .baseUrl(productServiceUrl)
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();
    }
}
