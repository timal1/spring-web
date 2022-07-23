package com.timal1.spring.web.cart.converters;

import com.timal1.spring.web.api.carts.CartDto;
import com.timal1.spring.web.api.carts.CartItemDto;
import com.timal1.spring.web.cart.models.Cart;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CartConverter {

    public CartDto modelToDto(Cart cart) {
        List<CartItemDto> cartItemDtos = cart.getItems().stream().map(it ->
                new CartItemDto(it.getProductId(), it.getProductTitle(), it.getQuantity(), it.getPricePerProduct(), it.getPrice())
        ).collect(Collectors.toList());
        CartDto cartDto = new CartDto(cartItemDtos, cart.getTotalPrice());
        return cartDto;
    }
}
