package com.timal1.spring.web.core.repositories;

import com.timal1.spring.web.core.entities.CategoryProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryProductRepository extends JpaRepository<CategoryProduct, Long> {
    Optional<CategoryProduct> findByTitle(String title);
}
