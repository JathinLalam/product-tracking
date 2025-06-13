package com.products.tracking.products_tracking.service;

import com.products.tracking.products_tracking.dto.ProductDto;
import com.products.tracking.products_tracking.exception.InvalidInputException;
import com.products.tracking.products_tracking.exception.ProductNotFoundException;
import com.products.tracking.products_tracking.model.Product;
import com.products.tracking.products_tracking.repository.ProductRepository;
import jakarta.transaction.Transactional;
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
        return productRepository.findAll();
    }

    public Product getProduct(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    @Transactional
    public Product createProduct(ProductDto productDto) {
        validateProductInput(productDto);
        Product product = modelMapper.map(productDto, Product.class);
        return productRepository.save(product);
    }

    @Transactional
    public Product updateProduct(Long id, ProductDto productDto) {
        validateProductInput(productDto);
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        modelMapper.getConfiguration().setSkipNullEnabled(true);
        modelMapper.map(productDto, existingProduct);

        return productRepository.save(existingProduct);
    }

    @Transactional
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException(id);
        }
        productRepository.deleteById(id);
    }

    private void validateProductInput(ProductDto productDto) {
        if (productDto.getName() == null || productDto.getName().trim().isEmpty()) {
            throw new InvalidInputException("Product name cannot be empty");
        }
        if (productDto.getPrice() == null || productDto.getPrice() <= 0) {
            throw new InvalidInputException("Price must be a positive value");
        }
    }
}
