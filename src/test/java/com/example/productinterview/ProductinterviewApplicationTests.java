package com.example.productinterview;

import com.example.productinterview.Controller.MainController;
import com.example.productinterview.Model.Product;
import com.example.productinterview.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductinterviewApplicationTests {

    @Autowired
    ProductService service;

    @Autowired
    MainController controller;

    private int port = 8081;
    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }

    @Test
    @Order(1)
    void getAllShouldReturnProductsList() throws Exception {
        String expectedJson = "[{\"id\":1,\"name\":\"Product 1 \",\"date\":\"1997-06-09T21:00:00.000+00:00\",\"price\":12.34},{\"id\":2,\"name\":\"Product 2\",\"date\":\"1997-12-31T22:00:00.000+00:00\",\"price\":30.4},{\"id\":3,\"name\":\"Product 3\",\"date\":\"1998-12-31T22:00:00.000+00:00\",\"price\":0.56}]";

        this.mockMvc.perform(get("http://localhost:" + port + "/products/all"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson));
    }

    @Test
    @Order(4)
    void addServiceTest() throws Exception {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.getDefault());
        LocalDate date = LocalDate.now();
        String formattedLocaldate = date.format(formatter);
        Date date2 = Date.from(date.atStartOfDay().toInstant(ZoneOffset.UTC));


        Product product = new Product(4, "Test product", date2, 99.99);
        ObjectMapper mapper = new ObjectMapper();

        mockMvc.perform(MockMvcRequestBuilders.
                post("http://localhost:" + port + "/products/add")
                .content(mapper.writeValueAsString(product))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.date", Matchers.containsString(formattedLocaldate)))
                .andExpect(jsonPath("$.name", Matchers.containsString("Test product")))
                .andExpect(jsonPath("$.price", Matchers.is(99.99)))
                .andExpect(jsonPath("$.id", Matchers.is(4)));
    }

    @Test
    @Order(2)
    void updateServiceTest() throws Exception {

        int id = 1;
        Product product = new Product(1, "Test product changed", new Date(), 199.99);

        mockMvc.perform(MockMvcRequestBuilders.
                put("http://localhost:" + port + "/products/" + id)
                .content(mapper.writeValueAsString(product))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name", Matchers.containsString(product.getName())))
                .andExpect(jsonPath("$.price", Matchers.is(product.getPrice())))
                .andExpect(jsonPath("$.id", Matchers.is(product.getId())));
    }

    @Test
    @Order(3)
    void deleteServiceTest() throws Exception {
        int id = 1;
        int id2 = 2;
        int id3 = 3;
        String expectedJson = "[]";

        mockMvc.perform(MockMvcRequestBuilders.
                delete("http://localhost:" + port + "/products/" + id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(""));
        mockMvc.perform(MockMvcRequestBuilders.
                delete("http://localhost:" + port + "/products/" + id2)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(""));
        mockMvc.perform(MockMvcRequestBuilders.
                delete("http://localhost:" + port + "/products/" + id3)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(""));

        this.mockMvc.perform(get("http://localhost:" + port + "/products/all"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson));
    }
}
