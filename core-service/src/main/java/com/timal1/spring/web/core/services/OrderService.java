package com.timal1.spring.web.core.services;

import com.timal1.spring.web.api.carts.CartDto;
import com.timal1.spring.web.api.exeptions.ResourceNotFoundException;
import com.timal1.spring.web.api.core.OrderDetailsDto;
import com.timal1.spring.web.core.entities.Order;
import com.timal1.spring.web.core.integrations.CartServiceIntegration;
import com.timal1.spring.web.core.repositories.OrderRepository;
import com.timal1.spring.web.core.entities.OrderItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductService productService;
    private final CartServiceIntegration cartServiceIntegration;

    public enum OrderStatus {
        AWAITING_PAYMENT, PAID, CANCELLED
    }

    @Transactional
    public void createOrder(String username, OrderDetailsDto orderDetailsDto) {
        CartDto currentCart = cartServiceIntegration.getUserCart(username);
        Order order = new Order();
        order.setAddress(orderDetailsDto.getAddress());
        order.setPhone(orderDetailsDto.getPhone());
        order.setUsername(username);
        order.setTotalPrice(currentCart.getTotalPrice());
        order.setStatus(OrderStatus.AWAITING_PAYMENT.name());
        List<OrderItem> items = currentCart.getItems().stream()
                .map(o -> {
                    OrderItem item = new OrderItem();
                    item.setProduct(productService.findById(o.getProductId())
                            .orElseThrow(() -> new ResourceNotFoundException("Not create order, the product is not found in the database, id: "
                                    + o.getProductId())));
                    item.setOrder(order);
                    item.setQuantity(o.getQuantity());
                    item.setPricePerProduct(o.getPricePerProduct());
                    item.setPrice(o.getPrice());
                   return item;
                }).collect(Collectors.toList());
        order.setItems(items);
        orderRepository.save(order);
        cartServiceIntegration.clearUserCart(username);
    }

    public List<Order> findOrdersByUserName(String username) {
        return orderRepository.findAllByUsername(username);
    }

    public Optional<Order> findById(Long orderId) {
       return orderRepository.findById(orderId);
    }
}
