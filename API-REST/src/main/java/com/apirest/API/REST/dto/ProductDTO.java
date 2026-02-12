package com.apirest.API.REST.dto;

import com.apirest.API.REST.model.ProductType;

import java.math.BigDecimal;

public record ProductDTO(Long id,
                         String name,
                         BigDecimal price,
                         ProductType type,
                         Integer stock) {
}
