package com.products.tracking.products_tracking.service;

import com.products.tracking.products_tracking.dto.ProductDto;
import com.products.tracking.products_tracking.model.Product;
import com.products.tracking.products_tracking.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public List<Product> getProducts() {
        return productRepository.getProducts();
    }

    public Product getProduct(Long id) {
        return productRepository.findProductById(id);
    }

    public Product createProduct(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        if (productRepository.findProductById(product.getId()) != null) {
            throw new RuntimeException("Product already exists");
        }
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, ProductDto productDto) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product with id " + id + " does not exist."));
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        modelMapper.map(productDto, existingProduct);
        return productRepository.save(existingProduct);
    }

    public void deleteProduct(Long id) {
        Product product = productRepository.findProductById(id);
        productRepository.delete(product);
    }
}
