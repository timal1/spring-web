package com.timal1.spring.web.core;

import com.timal1.spring.web.core.converters.ProductConverter;
import com.timal1.spring.web.core.entities.Product;
import com.timal1.spring.web.core.repositories.OrderRepository;
import com.timal1.spring.web.core.services.OrderService;
import com.timal1.spring.web.core.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@SpringBootTest
public class OrderServiceTest {

//    @Autowired
//    private OrderService orderService;
//
//    @Autowired
//    private ProductConverter productConverter;
//
//    @MockBean
//    private ProductService productService;
//
//    @MockBean
//    private OrderRepository orderRepository;
//
//    private Product product;
//    private String userName;
//    private String address;
//    private String phone;
//    private Cart cart;
//    private ProductDto productDto;
//
//    @BeforeEach
//    public void initCart() {
//        this.product = new Product();
//        this.product.setId(5L);
//        this.product.setTitle("chess");
//        this.product.setPrice(Double.valueOf(100.0));
//        this.userName = "EgorTest";
//        this.address = "Voronezh";
//        this.phone = "888888888888";
//        this.productDto = productConverter.entityToDto(product);
//        this.productDto.setAmount(3);
//        this.cart = new Cart();
//        this.cart.add(productDto);
//        this.cart.setTotalPrice(300.0);
//    }
//
//    @Test
//    public void createOrderTest() {
//        Mockito.doReturn(Optional.of(product)).when(productService).findById(5L);
//        orderService.createOrder(userName, address, phone, cart);
//        Mockito.verify(productService, Mockito.times(1)).findById(ArgumentMatchers.eq(5L));
//    }
}