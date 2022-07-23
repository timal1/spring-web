package com.timal1.spring.web.core.converters;


import com.timal1.spring.web.api.core.ProductDto;
import com.timal1.spring.web.core.entities.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    public Product dtoToEntity(ProductDto productDto) {
        return new Product(productDto.getId(), productDto.getTitle(), productDto.getPrice());
    }

    public ProductDto entityToDto(Product product) {
        return new ProductDto(product.getId(), product.getTitle(), product.getPrice());
    }
}
