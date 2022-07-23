package com.timal1.spring.web.core.integrations;

import com.timal1.spring.web.api.carts.CartDto;
import com.timal1.spring.web.api.exeptions.CartServiceAppError;
import com.timal1.spring.web.core.exeptions.CartServiceIntegrationException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Component
@RequiredArgsConstructor
public class CartServiceIntegration {
    private final WebClient cartServiceWebClient;

    public CartDto getUserCart(String username) {
        CartDto cartDto =cartServiceWebClient.get()
                .uri("/api/v1/cart/0")
                .header("username", username)
                .retrieve()
                .onStatus(
                        httpStatus -> httpStatus.is4xxClientError(),
                        clientResponse -> clientResponse.bodyToMono(CartServiceAppError.class).map(
                                body -> {
                                    if (body.getCode().equals(CartServiceAppError.CartServiceErrors.CART_NOT_FOUND.name())) {
                                        return new CartServiceIntegrationException("Выполнен некорректный запрос к сервису корзин: корзина не найдена");
                                    }
                                    if (body.getCode().equals(CartServiceAppError.CartServiceErrors.CART_IS_BROKEN.name())) {
                                        return new CartServiceIntegrationException("Выполнен некорректный запрос к сервису корзин: корзина сломана");
                                    }
                                    return new CartServiceIntegrationException("Выполнен некорректный запрос к сервису корзин: корзина сломана");
                                }
                        )
                )
//                .onStatus(HttpStatus::is4xxClientError, clientResponse -> Mono.error(new CartServiceIntegrationException("Выполнен некорректный запрос к сервису корзины")))
//                .onStatus(HttpStatus::is5xxServerError, clientResponse -> Mono.error(new CartServiceIntegrationException("Сервис корзин сломался")))
                .bodyToMono(CartDto.class)
                .block();
        return cartDto;
    }

    public void clearUserCart(String username) {
        cartServiceWebClient.get()
                .uri("/api/v1/cart/0/clear")
                .header("username", username)
                .retrieve()
                .toBodilessEntity()
                .block();
    }
}
