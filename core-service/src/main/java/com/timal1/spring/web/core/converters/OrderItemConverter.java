package com.timal1.spring.web.core.converters;


import com.timal1.spring.web.api.core.OrderItemDto;
import com.timal1.spring.web.core.entities.OrderItem;
import org.springframework.stereotype.Component;

@Component
public class OrderItemConverter {

    public OrderItem dtoToEntity(OrderItemDto orderItemDto) {
       throw new UnsupportedOperationException();
    }

    public OrderItemDto entityToDto(OrderItem orderItem) {
        return new OrderItemDto(orderItem.getProduct().getId(), orderItem.getProduct().getTitle(),
                orderItem.getQuantity(), orderItem.getPricePerProduct(),
                orderItem.getPrice());
    }
}
