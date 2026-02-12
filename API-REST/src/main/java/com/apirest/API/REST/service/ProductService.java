package com.apirest.API.REST.service;

import com.apirest.API.REST.exception.NameProductAlreadyExistsException;
import com.apirest.API.REST.exception.ProductNotFoundException;
import com.apirest.API.REST.model.Product;
import com.apirest.API.REST.model.ProductType;
import com.apirest.API.REST.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository){
        this.repository = repository;
    }

    public List<Product> getAll(){
        return repository.findAll();
    }

    public Product createProduct(Product product){
        if (repository.existsByName(product.getName()))
            throw new NameProductAlreadyExistsException("Nome já cadastrado");

        return repository.save(product);
    }

    public Product findById(Long id){
        return repository.findById(id).orElseThrow(() -> new ProductNotFoundException("Produto não encontrado"));
    }

    public Product findByName(String name){
        return repository.findByName(name).orElseThrow(() -> new ProductNotFoundException("Produto não encontrado"));
    }

    public List<Product> findProductsLessThanPrice(BigDecimal price){
        return repository.findByPriceLessThan(price);
    }

    public List<Product> findProductsGreaterThanPrice(BigDecimal price){
        return repository.acharProdutosValoresMaioresQue(price);
    }

    public List<Product> findByType(ProductType productType){
        return repository.findByType(productType);
    }
}
