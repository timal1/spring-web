package com.timal1.spring.web.cart.controllers;

import com.timal1.spring.web.api.carts.CartDto;
import com.timal1.spring.web.api.dto.StringResponse;
import com.timal1.spring.web.cart.converters.CartConverter;
import com.timal1.spring.web.cart.services.CartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cart")
public class CartController {
    private final CartService cartService;
    private final CartConverter cartConverter;

    @Operation(
            summary = "Запрос на получение корзины по uuid",
            responses = {
                    @ApiResponse(
                            description = "Успешный ответ", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = CartDto.class))
                    )
            }
    )
    @GetMapping("/{uuid}")
    public CartDto getCart(@RequestHeader(required = false) String username, @PathVariable @Parameter(description = "Идентификатор корзины", required = true) String uuid) {
        return cartConverter.modelToDto(cartService.getCurrentCart(getCurrentCartUuid(username, uuid)));
    }

    @Operation(
            summary = "Запрос на создание корзины",
            responses = {
                    @ApiResponse(
                            description = "Успешный ответ", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = StringResponse.class))
                    )
            }
    )
    @GetMapping("/generate")
    public StringResponse getCart() {
        return new StringResponse(cartService.generateCartUuid());
    }

    @Operation(
            summary = "Запрос на добавление продукта по id в корзину по UUID",
            responses = {
                    @ApiResponse(
                            description = "Успешный ответ", responseCode = "200"
                    )
            }
    )
    @GetMapping("/{uuid}/add/{productId}")
    public void add(@RequestHeader(required = false) String username,
                    @PathVariable @Parameter(description = "Идентификатор корзины", required = true) String uuid,
                    @PathVariable @Parameter(description = "Идентификатор продукта", required = true) Long productId)
    {
        cartService.addToCart(getCurrentCartUuid(username, uuid), productId);
    }

    @Operation(
            summary = "Запрос на изменение количества продукта по id в корзину по UUID",
            responses = {
                    @ApiResponse(
                            description = "Успешный ответ", responseCode = "200"
                    )
            }
    )
    @GetMapping("/{uuid}/decrement/{productId}")
    public void decrement(@RequestHeader(required = false) String username,
                          @PathVariable @Parameter(description = "Идентификатор корзины", required = true) String uuid,
                          @PathVariable @Parameter(description = "Идентификатор продукта", required = true) Long productId)
    {
        cartService.decrementItem(getCurrentCartUuid(username, uuid), productId);
    }

    @Operation(
            summary = "Запрос на удаление продукта по id в корзину по UUID",
            responses = {
                    @ApiResponse(
                            description = "Успешный ответ", responseCode = "200"
                    )
            }
    )
    @GetMapping("/{uuid}/remove/{productId}")
    public void remove(@RequestHeader(required = false) String username,
                       @PathVariable @Parameter(description = "Идентификатор корзины", required = true) String uuid,
                       @PathVariable @Parameter(description = "Идентификатор продукта", required = true) Long productId)
    {
        cartService.removeItemFromCart(getCurrentCartUuid(username, uuid), productId);
    }

    @Operation(
            summary = "Запрос на очистку корзины по UUID",
            responses = {
                    @ApiResponse(
                            description = "Успешный ответ", responseCode = "200"
                    )
            }
    )
    @GetMapping("/{uuid}/clear")
    public void clear(@RequestHeader(required = false) String username,
                      @PathVariable @Parameter(description = "Идентификатор корзины", required = true) String uuid) {
        cartService.clearCart(getCurrentCartUuid(username, uuid));
    }

    @Operation(
            summary = "Запрос на объединение корзины авторизованного пользователя и общей корзины по UUID",
            responses = {
                    @ApiResponse(
                            description = "Успешный ответ", responseCode = "200"
                    )
            }
    )
    @GetMapping("/{uuid}/merge")
    public void merge(@RequestHeader String username,
                      @PathVariable @Parameter(description = "Идентификатор корзины", required = true) String uuid) {
        cartService.merge(
                getCurrentCartUuid(username, null),
                getCurrentCartUuid(null, uuid)
        );
    }

    private String getCurrentCartUuid(String username, String uuid) {
        if (username != null) {
            return cartService.getCartUuidFromSuffix(username);
        }
        return cartService.getCartUuidFromSuffix(uuid);
    }
}
