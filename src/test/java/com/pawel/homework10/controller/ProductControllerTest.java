package com.pawel.homework10.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pawel.homework10.jpa.ProductDAO;
import com.pawel.homework10.model.Product;
import org.hamcrest.core.Is;
import org.jboss.jandex.JandexAntTask;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;
    Product productTest;

    public ProductControllerTest() {
        productTest = new Product();
        productTest.setName("chlebek");
    }

    @Test
    void add_product() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(productTest);
         mockMvc.perform(post("/list")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Is.is("chlebek")));
    }

    @Test
    void getProducts() throws Exception {
        mockMvc.perform(get("/list"))
                .andExpect(status().isOk());
    }


    @Test
    void editProduct() throws Exception {
        productTest.setName("piwko");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(productTest);
        mockMvc.perform(patch("/list")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name",Is.is("piwko")));
    }

    @Test
    void deleteProduct() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(productTest);
        mockMvc.perform(delete("/list")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isAccepted());
    }
}
