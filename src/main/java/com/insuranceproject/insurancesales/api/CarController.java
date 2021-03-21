package com.insuranceproject.insurancesales.api;


import com.insuranceproject.insurancesales.dao.CarJDBCDAO;
import com.insuranceproject.insurancesales.model.Car;
import com.insuranceproject.insurancesales.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/car")
@RestController
public class CarController {
    private final CarJDBCDAO carJDBCDAO;

    @Autowired
    public CarController(ClientService clientService, CarJDBCDAO carJDBCDAO) {
        this.carJDBCDAO = carJDBCDAO;
    }

    @PostMapping
    public void addCar(@RequestBody Car car) {
        carJDBCDAO.create(car);
    }

    @GetMapping
    public List<Car> selectAllAutoPolicy() {
        return carJDBCDAO.list();
    }

    @GetMapping(path = "car/{id}")
    public Car getCarByID(@PathVariable("id") int id) {
        return carJDBCDAO.get(id)
                .orElse(null);
    }

    @DeleteMapping(path = "car/{id}")
    public void deleteCarByID(@PathVariable("id") int id) {
        carJDBCDAO.delete(id);
    }

    @PutMapping(path = "car/{id}")
    public void updateClient(@PathVariable("id") int id, @RequestBody Car carToUpdate) {
        carJDBCDAO.update(carToUpdate, id);
    }
}
