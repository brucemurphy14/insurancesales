package com.insuranceproject.insurancesales.dao;

import com.insuranceproject.insurancesales.model.Car;
import com.insuranceproject.insurancesales.model.Client;
import org.springframework.dao.DataAccessException;
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


    public CarJDBCDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }




    @Override
    public List<Car> list() {
        String sql = "SELECT policy_number, vehicle_make, vehicle_model, vehicle_year FROM car";
        return jdbcTemplate.query(sql,rowMapper);
    }

    @Override
    public void create(Car car) {
        String sql = "insert into CAR(vehicle_make, vehicle_model, vehicle_year) values (?,?,?)";
        jdbcTemplate.update(sql, car.getVehicle_make(), car.getVehicle_model(), car.getVehicle_year());

    }

    @Override
    public Optional<Car> get(int id) {
        String sql = "Select policy_number, vehicle_make, vehicle_model, vehicle_year FROM car WHERE policy_number = ?";
        Car car = null;
        try {
            car = jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
        }
        catch (DataAccessException ex){
            //TO: meaningful errors
        }
        return Optional.ofNullable(car);
    }

    @Override
    public void update(Car car, int ID) {

        String sql = "update car set vehicle_make =  ?, vehicle_model = ?, vehicle_year = ? WHERE policy_number = ?";
        jdbcTemplate.update(sql,car.getVehicle_make(), car.getVehicle_model(), car.getVehicle_year());

    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("delete from car where policy_number = ?", id);
    }
}
