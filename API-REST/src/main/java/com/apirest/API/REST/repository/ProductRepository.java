package com.apirest.API.REST.repository;

import com.apirest.API.REST.model.Product;
import com.apirest.API.REST.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    public boolean existsByName(String name);

    public Optional<Product> findByName(String name);

    public List<Product> findByType(ProductType productType);

    public List<Product> findByPriceLessThan(BigDecimal price);

    @Query("SELECT p from Product p WHERE p.price > :price")
    public List<Product> acharProdutosValoresMaioresQue(@Param("price") BigDecimal price);
}
