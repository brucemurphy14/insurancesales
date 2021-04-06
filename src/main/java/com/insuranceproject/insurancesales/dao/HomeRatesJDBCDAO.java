package com.insuranceproject.insurancesales.dao;

import com.insuranceproject.insurancesales.model.HomeRate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * This DAO reads the rating information for home policies from the database.
 */
@Component
public class HomeRatesJDBCDAO implements DAO<HomeRate> {

    private final JdbcTemplate jdbcTemplate;

    RowMapper<HomeRate> rowMapper = (rs, rowNum) -> {
        HomeRate homeRate = new HomeRate();
        homeRate.setHome_policy_rate_id(rs.getInt("home_rating_id"));
        homeRate.setDwelling_type_single_dwelling_rate(rs.getFloat("dwelling_type_single_dwelling_rate"));
        homeRate.setDwelling_type_apartment_rate(rs.getFloat("dwelling_type_apartment_rate"));
        homeRate.setDwelling_type_bungalow_rate(rs.getFloat("dwelling_type_bungalow_rate"));
        homeRate.setDwelling_type_single_attached_rate(rs.getFloat("dwelling_type_single_attached_rate"));
        homeRate.setHome_age_under_25_rate(rs.getFloat("home_age_under_25_rate"));
        homeRate.setHome_age_25_or_over_rate(rs.getFloat("home_age_25_or_over_rate"));
        homeRate.setHome_age_50_or_over_rate(rs.getFloat("home_age_50_or_over_rate"));
        homeRate.setHeating_type_electric_rate(rs.getFloat("heating_type_electric_rate"));
        homeRate.setHeating_type_oil_rate(rs.getFloat("heating_type_oil_rate"));
        homeRate.setHeating_type_wood_rate(rs.getFloat("heating_type_wood_rate"));
        homeRate.setHeating_type_gas_rate(rs.getFloat("heating_type_gas_rate"));
        homeRate.setHeating_type_other_rate(rs.getFloat("heating_type_other_rate"));
        homeRate.setBase_premium_rate(rs.getFloat("base_premium_rate"));
        homeRate.setTax_rate(rs.getFloat("tax_rate"));

        return homeRate;
    };

    public HomeRatesJDBCDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<HomeRate> list() {
        String sql = "SELECT * FROM home_rating";
        return jdbcTemplate.query(sql,rowMapper);
    }

    @Override
    public void create(HomeRate homeRate) {

    }

    @Override
    public int createAndReturnAutoKey(HomeRate homeRate) {
        return 0;
    }

    @Override
    public Optional<HomeRate> get(int id) {
        return Optional.empty();
    }

    @Override
    public void update(HomeRate object, int ID) {

    }

    @Override
    public void delete(int id) {

    }
}
