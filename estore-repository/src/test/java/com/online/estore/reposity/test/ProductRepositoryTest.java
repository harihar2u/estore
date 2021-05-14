package com.online.estore.reposity.test;


import com.online.estore.core.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration

public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

//    @Test
    public void test(){

    }
}
