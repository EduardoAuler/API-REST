package com.apirest.API.REST.mapper;


import com.apirest.API.REST.dto.ProductDTO;
import com.apirest.API.REST.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toEntity(ProductDTO dto){
        return new Product(dto.id(), dto.name(), dto.price(), dto.type(), dto.stock());
    }

    public ProductDTO toDTO(Product product){
        return new ProductDTO(product.getId(), product.getName(),
                product.getPrice(), product.getType(), product.getStock());
    }

}
