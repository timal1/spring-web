package com.timal1.spring.web.api.core;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(description = "Модель единицы заказа")
public class OrderItemDto {

    @Schema(description = "ID продукта", required = true, example = "1")
    private Long productId;

    @Schema(description = "Название продукта", required = true, example = "пальто")
    private String productTitle;

    @Schema(description = "Количество штук продукта", required = true, example = "2")
    private int quantity;

    @Schema(description = "Стоимость одного продукта", required = true, example = "50.00")
    private BigDecimal pricePerProduct;

    @Schema(description = "Стоимость всех продуктов", required = true, example = "100.00")
    private BigDecimal price;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPricePerProduct() {
        return pricePerProduct;
    }

    public void setPricePerProduct(BigDecimal pricePerProduct) {
        this.pricePerProduct = pricePerProduct;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public OrderItemDto() {
    }

    public OrderItemDto(Long productId, String productTitle, int quantity, BigDecimal pricePerProduct, BigDecimal price) {
        this.productId = productId;
        this.productTitle = productTitle;
        this.quantity = quantity;
        this.pricePerProduct = pricePerProduct;
        this.price = price;
    }
}
