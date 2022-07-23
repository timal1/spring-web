package com.timal1.spring.web.core.configs;

import com.timal1.spring.web.core.properties.CartServiceIntegrationProperties;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableConfigurationProperties(
        CartServiceIntegrationProperties.class
)
@RequiredArgsConstructor
public class AppConfig {
    private final CartServiceIntegrationProperties cartServiceIntegrationProperties;

    @Bean
    public WebClient  cartServiceWebClient() {
        HttpClient httpClient = HttpClient
                .create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, cartServiceIntegrationProperties.getConnectTimeout())
                .doOnConnected(connection -> {
                    connection.addHandlerLast(new ReadTimeoutHandler(cartServiceIntegrationProperties.getReadTimeout(), TimeUnit.MILLISECONDS));
                    connection.addHandlerLast(new WriteTimeoutHandler(cartServiceIntegrationProperties.getWriteTimeout(), TimeUnit.MILLISECONDS));
                });

        return WebClient
                .builder()
                .baseUrl(cartServiceIntegrationProperties.getUrl())
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();
    }
}
