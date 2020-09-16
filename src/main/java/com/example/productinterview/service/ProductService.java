package com.example.productinterview.service;

import com.example.productinterview.ExceptionsProduct.ProductNotFoundException;
import com.example.productinterview.Model.Product;
import com.example.productinterview.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Iterable<Product> findAll(){
        return repository.findAll();
    }

    public Product add(Product product){
        return repository.save(product);
    }

    public Product update(Product product, Integer id){
        repository.findById(id)
                .orElseThrow(ProductNotFoundException::new);
        return repository.save(product);
    }

    public void delete(Integer id){
        repository.findById(id)
                .orElseThrow(ProductNotFoundException::new);
        repository.deleteById(id);
    }
}
