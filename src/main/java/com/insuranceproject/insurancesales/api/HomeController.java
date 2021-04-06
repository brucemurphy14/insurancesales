package com.insuranceproject.insurancesales.api;

import com.insuranceproject.insurancesales.dao.HomeJDBCDAO;

import com.insuranceproject.insurancesales.model.Home;
import com.insuranceproject.insurancesales.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/home")
@RestController
public class HomeController {
    private final HomeJDBCDAO homeJDBCDAO;

    @Autowired
    public HomeController(ClientService clientService, HomeJDBCDAO homeJDBCDAO) {
        this.homeJDBCDAO = homeJDBCDAO;
    }

    @PostMapping
    public void addCar(@RequestBody Home home) {
        homeJDBCDAO.create(home);
    }

    @GetMapping
    public List<Home> selectAllAutoPolicy() {
        return homeJDBCDAO.list();
    }

    @GetMapping(path = "home/{id}")
    public Home getHomeByID(@PathVariable("id") int id) {
        return homeJDBCDAO.get(id)
                .orElse(null);
    }

    @DeleteMapping(path = "home/{id}")
    public void deleteCarByID(@PathVariable("id") int id) {
        homeJDBCDAO.delete(id);
    }

    @PutMapping(path = "car/{id}")
    public void updateClient(@PathVariable("id") int id, @RequestBody Home homeToUpdate) {
        homeJDBCDAO.update(homeToUpdate, id);
    }
}