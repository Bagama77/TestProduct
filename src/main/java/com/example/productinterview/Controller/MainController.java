package com.example.productinterview.Controller;

import com.example.productinterview.ExceptionsProduct.ProductIdMismatchException;
import com.example.productinterview.ExceptionsProduct.ProductNotFoundException;
import com.example.productinterview.Model.Product;
import com.example.productinterview.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.logging.Logger;

@RestController
@RequestMapping("/products")
public class MainController {

    @Autowired
    ProductService productService;

    Logger logger = Logger.getLogger("Main_Controller");

    @GetMapping("/all")
    public Iterable<Product> productsList() {
        return productService.findAll();
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody Product product) {
        return productService.add(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        try {
            productService.delete(id);
        } catch (ProductNotFoundException e){
            e.printStackTrace();
        }
    }

    @PutMapping("/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable int id) throws ProductIdMismatchException, ProductNotFoundException{
        if (product.getId() != id) {
            throw new ProductIdMismatchException();
        }
        return productService.update(product, id);
    }
}
