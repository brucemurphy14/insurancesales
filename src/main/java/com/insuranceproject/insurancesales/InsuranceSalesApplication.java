package com.insuranceproject.insurancesales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication//(exclude = SecurityAutoConfiguration.class)
public class InsuranceSalesApplication {
    public static void main(String[] args) {
        SpringApplication.run(InsuranceSalesApplication.class, args);
    }
}
