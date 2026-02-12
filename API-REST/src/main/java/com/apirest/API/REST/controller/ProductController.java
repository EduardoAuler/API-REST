package com.apirest.API.REST.controller;


import com.apirest.API.REST.dto.ProductDTO;
import com.apirest.API.REST.mapper.ProductMapper;
import com.apirest.API.REST.model.Product;
import com.apirest.API.REST.model.ProductType;
import com.apirest.API.REST.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/products")
public class ProductController {

    private final ProductMapper mapper;
    private final ProductService service;

    public ProductController(ProductMapper mapper, ProductService service) {
        this.mapper = mapper;
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getProducts(){
        List<ProductDTO> response = service.getAll().stream()
                .map(mapper::toDTO)
                .toList();

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO dto){
        Product product = mapper.toEntity(dto);
        Product saved = service.createProduct(product);
        ProductDTO response = mapper.toDTO(saved);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/type/{productType}")
    public ResponseEntity<List<ProductDTO>> getByType(@PathVariable ProductType productType){
        List<ProductDTO> response = service.findByType(productType).stream()
                .map(mapper::toDTO)
                .toList();

        return ResponseEntity.ok(response);
    }

}
