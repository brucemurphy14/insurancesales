package com.insuranceproject.insurancesales.dao;

import com.insuranceproject.insurancesales.model.Auto_Policy;
import com.insuranceproject.insurancesales.model.Client;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;
import java.util.Optional;
//TODO implement interface methods
public class Auto_PolicyJDbcdao implements DAO<Auto_Policy> {

    private JdbcTemplate jdbcTemplate;

    RowMapper<Auto_Policy> rowMapper = (rs, rowNum) -> {
        Auto_Policy auto_policy = new Auto_Policy();
        auto_policy.setClient_id(rs.getInt("Client_ID"));
        auto_policy.setMain_insured_name(rs.getString("main_insured_name"));
        auto_policy.setStart_date(rs.getDate("start_date"));
        auto_policy.setEnd_date(rs.getDate("end_date"));
        auto_policy.setBase_premium(rs.getFloat("base_premium"));
        auto_policy.setTotal_premium(rs.getFloat("total_premium"));
        auto_policy.setTax(rs.getFloat("tax"));
        auto_policy.setNumber_of_accidents_last_5_years(rs.getInt("number_of_accidents_last_5_years"));
        auto_policy.setAddress(rs.getString("address"));
        return auto_policy;
    };


    @Override
    public List<Auto_Policy> list() {

        return null;
    }

    @Override
    public void create(Auto_Policy auto_policy) {

    }

    @Override
    public Optional<Auto_Policy> get(int id) {
        return Optional.empty();
    }

    @Override
    public void update(Auto_Policy object, int ID) {

    }

    @Override
    public void delete(int id) {

    }
}
