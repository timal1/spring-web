package com.timal1.spring.web.core.repositories.specifications;

import com.timal1.spring.web.core.entities.CategoryProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@RequiredArgsConstructor
public class CategoriesProductsSpecifications {
    public static Specification<CategoryProduct> categoryLike(String categoryTitle) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("title"), String.format("%%%s%%", categoryTitle));

    }
}
