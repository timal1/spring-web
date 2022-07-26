package com.timal1.spring.web.core;

import com.timal1.spring.web.api.carts.CartDto;
import com.timal1.spring.web.api.carts.CartItemDto;
import com.timal1.spring.web.api.core.OrderDetailsDto;
import com.timal1.spring.web.core.integrations.CartServiceIntegration;
import com.timal1.spring.web.core.services.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ContextHierarchy(@ContextConfiguration)
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @MockBean
    private CartServiceIntegration cartServiceIntegration;
    private CartItemDto cartItemDto;
    private CartDto cartDto;
    private String username;
    private List<CartItemDto> items;
    private OrderDetailsDto orderDetailsDto;

    @BeforeEach
    public void initCart() {
        this.cartItemDto = new CartItemDto();
        this.cartItemDto.setProductId(5L);
        this.cartItemDto.setProductTitle("chess");
        this.cartItemDto.setQuantity(2);
        this.cartItemDto.setPricePerProduct(BigDecimal.valueOf(50.0));
        this.cartItemDto.setPrice(BigDecimal.valueOf(100.0));
        this.username = "EgorTest";
        this.cartDto = new CartDto();
        this.cartDto.setTotalPrice(BigDecimal.valueOf(100.0));
        this.items = items = new ArrayList<>();
        this.items.add(cartItemDto);
        this.cartDto.setItems(items);
        this.orderDetailsDto = new OrderDetailsDto();
        this.orderDetailsDto.setAddress("Voronezh");
        this.orderDetailsDto.setPhone("88008880000");

    }

    @Test
    public void createOrderTest() {
        Mockito.doReturn(cartDto).when(cartServiceIntegration).getUserCart(username);
        orderService.createOrder(username, orderDetailsDto);
        Mockito.verify(cartServiceIntegration, Mockito.times(1)).getUserCart("EgorTest");
    }
}