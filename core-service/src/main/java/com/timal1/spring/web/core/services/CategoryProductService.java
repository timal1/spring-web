package com.timal1.spring.web.core.services;

import com.timal1.spring.web.api.exeptions.ResourceNotFoundException;
import com.timal1.spring.web.core.entities.CategoryProduct;
import com.timal1.spring.web.core.repositories.CategoryProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CategoryProductService {

    private final CategoryProductRepository categoryProductRepository;


    public Long findIdByTitle(String categoryPart) {

        CategoryProduct categoryProduct = categoryProductRepository.findByTitle(categoryPart).orElseThrow(
                () -> new ResourceNotFoundException("Product not found"));

        return categoryProduct.getId();
    }

}
