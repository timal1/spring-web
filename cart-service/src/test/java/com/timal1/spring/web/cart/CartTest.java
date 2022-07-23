package com.timal1.spring.web.cart;

import com.timal1.spring.web.cart.services.CartService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CartTest {
//    @Autowired
//    private CartService cartService;
//
//    private  ProductDto productDto;
//    @BeforeEach
//    public void initCart() {
//        this.productDto = new ProductDto();
//        this.productDto.setId(5L);
//        this.productDto.setTitle("chess");
//        this.productDto.setPrice(Double.valueOf(100.0));
//        this.productDto.setAmount(1);
//        cartService.clearCart("test_cart");
//    }
//
//    @Test
//    public void addToCartTest() {
//
//        cartService.addToCart("test_cart", productDto);
//        cartService.addToCart("test_cart", productDto);
//        cartService.addToCart("test_cart", productDto);
//
//        Assertions.assertEquals(1, cartService.getCurrentCart("test_cart").getItems().size());
//    }
//
//    @Test
//    public void removeItemFromCartTest() {
//
//        cartService.removeItemFromCart("test_cart", 5L);
//        cartService.removeItemFromCart("test_cart", 5L);
//        cartService.removeItemFromCart("test_cart", 5L);
//
//        Assertions.assertEquals(0, cartService.getCurrentCart("test_cart").getItems().size());
//    }
//
//    @Test
//    public void decrementItemTest() {
//        cartService.addToCart("test_cart", productDto);
//        cartService.addToCart("test_cart", productDto);
//        cartService.addToCart("test_cart", productDto);
//
//        cartService.decrementItem("test_cart", 5L);
//        cartService.decrementItem("test_cart", 5L);
//        cartService.decrementItem("test_cart", 5L);
//
//        Assertions.assertEquals(0, cartService.getCurrentCart("test_cart").getItems().size());
//    }
}