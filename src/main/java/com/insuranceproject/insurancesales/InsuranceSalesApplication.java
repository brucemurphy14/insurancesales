package com.insuranceproject.insurancesales;

import com.insuranceproject.insurancesales.dao.DAO;
import com.insuranceproject.insurancesales.model.Client;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class InsuranceSalesApplication {

    private static DAO<Client>  dao;

    public InsuranceSalesApplication(DAO<Client> dao) {
        this.dao = dao;
    }


    public static void main(String[] args) {
        SpringApplication.run(InsuranceSalesApplication.class, args);

        System.out.println("~~TESTAN HERE~~~~~~~~~~~~");
        List<Client> clients = dao.list();
        clients.forEach(System.out::println);
        System.out.println("~~TESTAN HERE~~~~~~~~~~~~");
        Client nc = new Client("Jim brown", 10, 1,"1 ropewalk lane");
        dao.create(nc);
        clients.forEach(System.out::println);
    }

}
