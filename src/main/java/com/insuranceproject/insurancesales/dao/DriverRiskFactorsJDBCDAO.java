package com.insuranceproject.insurancesales.dao;

import com.insuranceproject.insurancesales.model.Auto_Policy;
import com.insuranceproject.insurancesales.model.DriverRiskFactors;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;
import java.util.Optional;

public class DriverRiskFactorsJDBCDAO implements DAO<DriverRiskFactors> {

    JdbcTemplate jdbcTemplate;
    RowMapper<DriverRiskFactors> rowMapper = (rs, rowNum) -> {
        DriverRiskFactors driverRiskFactors = new DriverRiskFactors();
        driverRiskFactors.setDriverAge(rs.getDate("driver_age"));
        driverRiskFactors.setVehicleAge(rs.getInt("vehicle_year"));
        driverRiskFactors.setAccidentCount(rs.getInt("accident_id"));
        return driverRiskFactors;
    };

    @Override
    public List<DriverRiskFactors> list() {
        String sql = "select client_birthday, vehicle_year, accident_id from CLIENT, accident_listing, policy_holder, policy, auto_policy, car\n" +
                "                WHERE accident_listing.client_id = client.client_id AND client.auto_policy_number = policy_holder.policy_number AND policy.policy_number = policy_holder.policy_number\n" +
                "                AND auto_policy.policy_number = policy.policy_number AND auto_policy.VIN_NUMBER = CAR.vin_number AND client.CLIENT_ID = 1;";

        return jdbcTemplate.query(sql,rowMapper);

    }

    @Override
    public void create(DriverRiskFactors driverRiskFactors) {

    }

    @Override
    public Optional<DriverRiskFactors> get(int id) {
        return Optional.empty();
    }

    @Override
    public void update(DriverRiskFactors object, int ID) {

    }

    @Override
    public void delete(int id) {

    }
}
