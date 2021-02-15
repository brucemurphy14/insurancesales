package com.insuranceproject.insurancesales.dao;

import com.insuranceproject.insurancesales.model.Auto_Policy;
import com.insuranceproject.insurancesales.model.Car;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;
import java.util.Optional;

public class CarJDBCDAO implements DAO<Car>{
//TODO implement interface methods
    private JdbcTemplate jdbcTemplate;

    RowMapper<Car> rowMapper = (rs, rowNum) -> {
        Car car = new Car();
        car.setClient_id(rs.getInt("Client_ID"));
        car.setVehicle_make(rs.getString("vehicle_make"));
        car.setVehicle_model(rs.getString("vehicle_model"));
        car.setVehicle_year(rs.getInt("vehicle_year"));
        return car;
    };




    @Override
    public List<Car> list() {
        return null;
    }

    @Override
    public void create(Car car) {

    }

    @Override
    public Optional<Car> get(int id) {
        return Optional.empty();
    }

    @Override
    public void update(Car object, int ID) {

    }

    @Override
    public void delete(int id) {

    }
}
