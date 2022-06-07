package com.alfa.test_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TestProjectApplication {

    public static void main(String[] args) {

        SpringApplication.run(TestProjectApplication.class, args);
    }

}
