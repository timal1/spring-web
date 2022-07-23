package com.timal1.spring.web.api.core;


import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.util.List;

@Schema(description = "Модель заказа")
public class OrderDto {

    @Schema(description = "ID заказа", required = true, example = "1")
    private Long id;
    @Schema(description = "Стоимость всего заказа", required = true, example = "200.00")
    private BigDecimal totalPrice;

    @Schema(description = "Адрес покупателя", example = "г. Москва ул. Виноградная д. 3 кв. 5")
    private String address;

    @Schema(description = "Телефон покупателя", example = "8-900-000-00-00")
    private String phone;

    @Schema(description = "Имя покупателя", example = "Иван")
    private String userName;

    @ArraySchema(schema = @Schema(description = "Список продуктов", implementation = OrderItemDto.class))
    private List<OrderItemDto> items;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<OrderItemDto> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDto> items) {
        this.items = items;
    }

    public OrderDto() {
    }

    public OrderDto(Long id, BigDecimal totalPrice, String address, String phone, String userName, List<OrderItemDto> items) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.address = address;
        this.phone = phone;
        this.userName = userName;
        this.items = items;
    }
}
