package com.insuranceproject.insurancesales.dao;

import com.insuranceproject.insurancesales.model.AutoRate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AutoRatesJDBCDAO implements DAO<AutoRate> {
    private final JdbcTemplate jdbcTemplate;

    RowMapper<AutoRate> rowMapper = (rs, rowNum) -> {
        AutoRate autoRate = new AutoRate();
        autoRate.setAuto_policy_rate_id(rs.getInt("auto_rating_id"));
        autoRate.setDriver_age_25_or_under_rate(rs.getFloat("driver_age_25_or_under_rate"));
        autoRate.setDriver_age_other_rate(rs.getFloat("driver_age_other_rate"));
        autoRate.setLocation_rate_dense_urban(rs.getFloat("location_rate_dense_urban"));
        autoRate.setLocation_rate_urban(rs.getFloat("location_rate_urban"));
        autoRate.setLocation_rate_rural(rs.getFloat("location_rate_rural"));
        autoRate.setNo_accidents_last_5_years_rate(rs.getFloat("driver_0_accident_last_5_years_rate"));
        autoRate.setOne_accident_last_5_years_rate(rs.getFloat("driver_1_accidents_last_5_years_rate"));
        autoRate.setTwo_or_more_accidents_last_5_years_rate(rs.getFloat("driver_2_accidents_last_5_years_rate"));
        autoRate.setCar_11_years_or_older_rate(rs.getFloat("car_11_years_or_older_rate"));
        autoRate.setCar_older_than_5_years_rate(rs.getFloat("car_older_than_5_years_rate"));
        autoRate.setCar_age_other_rate(rs.getFloat("car_other_age_rate"));
        autoRate.setBase_premium_rate(rs.getFloat("base_premium_rate"));
        return autoRate;
    };

    public AutoRatesJDBCDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<AutoRate> list() {
        String sql = "SELECT * FROM auto_rating";
        return jdbcTemplate.query(sql,rowMapper);
    }

    @Override
    public void create(AutoRate autoRate) {

    }

    @Override
    public Optional<AutoRate> get(int id) {
        return Optional.empty();
    }

    @Override
    public void update(AutoRate object, int ID) {

    }

    @Override
    public void delete(int id) {

    }
}
