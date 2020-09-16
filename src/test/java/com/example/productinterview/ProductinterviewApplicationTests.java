package com.example.productinterview;

import com.example.productinterview.Model.Product;
import com.example.productinterview.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

@SpringBootTest
class ProductinterviewApplicationTests {

    @Autowired
    ProductService service;

    @Test
    void contextLoads() {
    }

    @Test
    void findAllServiceTest(){

    }

    @Test
    void addServiceTest(){

    }

    @Test
    void updateServiceTest(){

    }

    @Test
    void deleteServiceTest(){

    }

    @Test
    public void givenProductHasNoName_whenInvalidEntityIsCreated_thenDataException() {
        try {
            service.add(new Product());

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
