package com.timal1.spring.web.core.converters;

import com.timal1.spring.web.api.core.OrderDto;
import com.timal1.spring.web.core.entities.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderConverter {
    private final OrderItemConverter orderItemConverter;

    public Order dtoToEntity(OrderDto orderDto) {
       throw new UnsupportedOperationException();
    }

    public OrderDto entityToDto(Order order) {
        OrderDto out = new OrderDto();
        out.setId(order.getId());
        out.setAddress(order.getAddress());
        out.setPhone(order.getPhone());
        out.setTotalPrice(order.getTotalPrice());
        out.setUserName(order.getUsername());
        out.setItems(order.getItems().stream().map(orderItemConverter::entityToDto).collect(Collectors.toList()));
        return out;
    }
}
