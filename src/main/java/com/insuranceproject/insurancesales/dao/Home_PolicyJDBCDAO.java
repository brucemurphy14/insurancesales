package com.insuranceproject.insurancesales.dao;

import com.insuranceproject.insurancesales.model.Home_Policy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;
import java.util.Optional;

public class Home_PolicyJDBCDAO implements DAO<Home_Policy> {
//TODO implement interface methods
    private JdbcTemplate jdbcTemplate;

    RowMapper<Home_Policy> rowMapper = (rs, rowNum) -> {
        Home_Policy homePolicy = new Home_Policy();
        homePolicy.setPolicy_number(rs.getInt("policy_number"));
        homePolicy.setMain_insured_name(rs.getString("main_insured_name"));
        homePolicy.setOther_insured_names(rs.getString("other_insured_names"));
        homePolicy.setStart_date(rs.getDate("start_date"));
        homePolicy.setEnd_date(rs.getDate("end_date"));
        homePolicy.setBase_premium(rs.getFloat("base_premium"));
        homePolicy.setTotal_premium(rs.getFloat("total_premium"));
        homePolicy.setReplacement_cost_value(rs.getFloat("replacement_cost_value"));
        homePolicy.setInjury_liability_limit(rs.getFloat("injury_liability_limit"));
        homePolicy.setInjury_deductible(rs.getFloat("injury_deductible"));
        homePolicy.setContents_liability_limit(rs.getFloat("contents_liability_limit"));
        homePolicy.setContents_deductible(rs.getFloat("contents_deductible"));
        return homePolicy;
    };


    @Override
    public List<Home_Policy> list() {
        return null;
    }

    @Override
    public void create(Home_Policy home_policy) {

    }

    @Override
    public Optional<Home_Policy> get(int id) {
        return Optional.empty();
    }

    @Override
    public void update(Home_Policy object, int ID) {

    }

    @Override
    public void delete(int id) {

    }
}
