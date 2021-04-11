package com.insuranceproject.insurancesales.dao;

import com.insuranceproject.insurancesales.model.Car;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * This DAO class handles interactions with the car table.
 */
@Component
public class CarJDBCDAO implements DAO<Car>{


    //TODO implement interface methods
    private final JdbcTemplate jdbcTemplate;

    RowMapper<Car> rowMapper = (rs, rowNum) -> {
        Car car = new Car();
        car.setVin_number(rs.getInt("VIN_NUMBER"));
        car.setPolicy_number(rs.getInt("policy_number"));
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
        String sql = "SELECT VIN_NUMBER, policy_number, vehicle_make, vehicle_model, vehicle_year FROM car";
        return jdbcTemplate.query(sql,rowMapper);
    }

    @Override
    public  void create(Car car) {
        String sql = "insert into CAR(vehicle_make, vehicle_model, vehicle_year, policy_number) values (?,?,?, (SELECT MAX(policy_number) from policy))";
        jdbcTemplate.update(sql, car.getVehicle_make(), car.getVehicle_model(), car.getVehicle_year());

    }

    @Override
    public int createAndReturnAutoKey(Car car) {
        return 0;
    }

    @Override
    public Optional<Car> get(int id) {
        String sql = "Select VIN_NUMBER, policy_number, vehicle_make, vehicle_model, vehicle_year FROM car WHERE VIN_NUMBER = ?";
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
        String sql = "update car set vehicle_make =  ?, vehicle_model = ?, vehicle_year = ? WHERE VIN_NUMBER = ?";
        jdbcTemplate.update(sql,car.getVehicle_make(), car.getVehicle_model(), car.getVehicle_year());
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("delete from car where policy_number = ?", id);
    }
}
