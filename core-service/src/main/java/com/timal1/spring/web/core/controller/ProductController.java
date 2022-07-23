package com.timal1.spring.web.core.controller;

import com.timal1.spring.web.api.core.ProductDto;
import com.timal1.spring.web.api.exeptions.ResourceNotFoundException;
import com.timal1.spring.web.core.validators.ProductValidator;
import com.timal1.spring.web.core.entities.Product;
import com.timal1.spring.web.core.services.ProductService;
import com.timal1.spring.web.core.converters.ProductConverter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
@Tag(name = "Продукты", description = "Методы для работы с продуктами")
public class ProductController {

    private final ProductService productService;
    private final ProductConverter productConverter;
    private final ProductValidator productValidator;

    @Operation(
            summary = "Запрос на получение страницы продуктов",
            responses = {
                    @ApiResponse(
                            description = "Успешный ответ", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = Page.class))
                    )
            }
    )
    @GetMapping
    public Page<ProductDto> getAllProducts(
            @RequestParam(name = "number_page") @Parameter(description = "Номер страницы") Integer page,
            @RequestParam(name = "max_price", required = false) @Parameter(description = "Максимальная цена") Double maxPrice,
            @RequestParam(name = "min_price", required = false) @Parameter(description = "Минимальная цена") Double minPrice,
            @RequestParam(name = "title_part", required = false) @Parameter(description = "Часть названия продукта") String titlePart,
            @RequestParam(name = "category_part", required = false) @Parameter(description = "Название категории") String categoryPart
    ) {
        if (page < 1) {
            page = 1;
        }
        return productService.find(minPrice, maxPrice, titlePart, page, categoryPart).map(
                p -> productConverter.entityToDto(p)
        );
    }

    @Operation(
            summary = "Запрос на получение объектов по id",
            responses = {
                    @ApiResponse(
                            description = "Успешный ответ", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = ProductDto.class))
                    )
            }
    )
    @GetMapping("/{id}")
    public ProductDto getProductById(
            @PathVariable @Parameter(description = "Идентификатор продукта", required = true) Long id
    ) {
        Product product = productService.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Product not found, id: " + id));
        return productConverter.entityToDto(product);
    }

    @Operation(
            summary = "Сохранение нового продукта",
            responses = {
                    @ApiResponse(
                            description = "Успешный ответ", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = ProductDto.class))
                    )
            }
    )
    @PostMapping
    public ProductDto saveNewProduct(@RequestBody ProductDto productDto) {
        productValidator.validate(productDto);
        Product product = productConverter.dtoToEntity(productDto);
        product = productService.save(product);
        return productConverter.entityToDto(product);
    }

    @Operation(
            summary = "Удаление продукта по id",
            responses = {
                    @ApiResponse(
                            description = "Успешный ответ", responseCode = "200"
                    )
            }
    )
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable @Parameter(description = "Идентификатор продукта", required = true) Long id) {
        productService.deleteById(id);
    }

    @Operation(
            summary = "Изменение продукта",
            responses = {
                    @ApiResponse(
                            description = "Успешный ответ", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = ProductDto.class))
                    )
            }
    )
    @PutMapping
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        productValidator.validate(productDto);
        Product product = productService.update(productDto);
        return productConverter.entityToDto(product);
    }
}
