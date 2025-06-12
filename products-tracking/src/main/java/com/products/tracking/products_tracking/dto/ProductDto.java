package com.products.tracking.products_tracking.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ProductDto {
    private Long id;
    @NotNull(message = "Name cannot be null")
    private String name;
    @NotNull(message = "Description cannot be null")
    private String description;
    @NotNull(message = "Price cannot be null")
    @Positive(message = "Price must be positive")
    private Double price;
}
