package com.insuranceproject.insurancesales.dao;

import com.insuranceproject.insurancesales.model.Home;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;
import java.util.Optional;

//TODO implement interface methods
public class HomeJDBCDAO implements DAO<Home>{

    RowMapper<Home> rowMapper = (rs, rowNum) -> {
        Home home = new Home();
        home.setPolicy_number(rs.getInt("policy_number"));
        home.setAge_since_built(rs.getInt("age_since_built"));
        home.setType_of_dwelling(rs.getString("type_of_dwellings"));
        home.setHeating_type(rs.getString("heating_type"));
        return home;
    };

    @Override
    public List<Home> list() {
        return null;
    }

    @Override
    public void create(Home home) {

    }

    @Override
    public Optional<Home> get(int id) {
        return Optional.empty();
    }

    @Override
    public void update(Home object, int ID) {

    }

    @Override
    public void delete(int id) {

    }
}
