package com.timal1.spring.web.core.services;

import com.timal1.spring.web.api.core.ProductDto;
import com.timal1.spring.web.api.exeptions.ResourceNotFoundException;
import com.timal1.spring.web.core.repositories.ProductRepository;
import com.timal1.spring.web.core.repositories.specifications.ProductsSpecifications;
import com.timal1.spring.web.core.entities.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryProductService categoryProductService;

    public Page<Product> find(Double minPrice, Double maxPrice, String titlePart, Integer page, String categoryPart) {
        Specification<Product> spec = Specification.where(null);
        if (minPrice != null) {
            spec = spec.and(ProductsSpecifications.priceGreaterOrEqualsThan(minPrice));
        }
        if (maxPrice != null) {
            spec = spec.and(ProductsSpecifications.priceLessThanOrEqualsThan(maxPrice));
        }
        if (titlePart != null) {
            spec = spec.and(ProductsSpecifications.titleLike(titlePart));
        }
        if (categoryPart != null) {
            Long categoryId = categoryProductService.findIdByTitle(categoryPart);
            spec = spec.and(ProductsSpecifications.categoryLike(categoryId));
        }
        return productRepository.findAll(spec, PageRequest.of(page - 1, 5));
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Transactional
    public Product update(ProductDto productDto) {
        Product product = productRepository.findById(productDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Unable to update, the product is not found in the database, id: "
                        + productDto.getId()));
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        return product;
    }
}
