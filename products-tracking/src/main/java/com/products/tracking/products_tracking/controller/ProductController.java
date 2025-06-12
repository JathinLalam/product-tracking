package com.products.tracking.products_tracking.controller;

import com.products.tracking.products_tracking.dto.ProductDto;
import com.products.tracking.products_tracking.model.Product;
import com.products.tracking.products_tracking.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    public Product getProduct(
            @PathVariable Long id) {
        return productService.getProduct(id);
    }

    @PostMapping
    public Product createProduct(
            @RequestBody ProductDto productDto
    ) {
        return productService.createProduct(productDto);
    }

    @PutMapping("/{id}")
    public Product updateProduct(
            @PathVariable Long id,
            @RequestBody ProductDto productDto
    ) {
        return productService.updateProduct(id, productDto);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(
            @PathVariable Long id
    ) {
        productService.deleteProduct(id);
    }
}
