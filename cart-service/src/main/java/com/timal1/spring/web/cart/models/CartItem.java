package com.timal1.spring.web.cart.models;

import com.timal1.spring.web.api.core.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
    private Long productId;
    private String productTitle;
    private int quantity;
    private BigDecimal pricePerProduct;
    private BigDecimal price;

    public CartItem(ProductDto productDto) {
        this.productId = productDto.getId();
        this.productTitle = productDto.getTitle();
        this.quantity = 1;
        this.pricePerProduct = productDto.getPrice();
        this.price = productDto.getPrice();
    }

    public void changeQuantity(double delta) {
        this.quantity += delta;
        this.price = this.pricePerProduct.multiply(BigDecimal.valueOf(this.quantity));
    }
}
