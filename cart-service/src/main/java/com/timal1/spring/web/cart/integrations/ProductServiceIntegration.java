package com.timal1.spring.web.cart.integrations;

import com.timal1.spring.web.api.core.ProductDto;
import com.timal1.spring.web.api.exeptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProductServiceIntegration {
    private final WebClient productServiceWebClient;

    public Optional<ProductDto> getProductById(Long id) {
        ProductDto productDto = productServiceWebClient.get()
                .uri("/api/v1/products/" + id)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                error -> Mono.error(new ResourceNotFoundException("Продукт не найден с id: " + id)))
                .bodyToMono(ProductDto.class)
                .block();
        return Optional.of(productDto);
    }
}
