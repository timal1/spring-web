package com.timal1.spring.web.core.repositories.specifications;

import com.timal1.spring.web.core.entities.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@RequiredArgsConstructor
public class ProductsSpecifications {

    public static Specification<Product> priceGreaterOrEqualsThan(Double price) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("price"), price);
    }

    public static Specification<Product> priceLessThanOrEqualsThan(Double price) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("price"), price);
    }

    public static Specification<Product> titleLike(String titlePart) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("title"), String.format("%%%s%%", titlePart));
    }

    public static Specification<Product> categoryLike(Long categoryId) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("category"), categoryId);

    }
}
