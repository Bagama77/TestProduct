package com.example.productinterview.Repository;

import com.example.productinterview.Model.Product;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

@EnableJpaRepositories(basePackages = "com.example.productinterview.Repository")
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
