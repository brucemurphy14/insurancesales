package com.insuranceproject.insurancesales.dao;

import com.insuranceproject.insurancesales.model.Auto_Policy;
import com.insuranceproject.insurancesales.model.Home_Policy;
import org.springframework.dao.DataAccessException;
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
        String sql = "SELECT policy_number, client_id, main_insured_name,start_date, end_date, base_premium< tax, total_premium" +
                ", replacement_cost_value, injury_liability_limit, injury_deductible, contents_liability_limit, contents_deductible FROM Home_policy";
        return jdbcTemplate.query(sql,rowMapper);

    }

    @Override
    public void create(Home_Policy home_policy) {
        String sql = "Insert into Home_policy(client_id, main_insured_name,start_date, end_date, base_premium, tax, total_premium" +
                ", replacement_cost_value, injury_liability_limit, injury_deductible, contents_liability_limit, contents_deductible)" +
                 " values(?,?,?,?,?,?,?,?,?,?,?,?)";

        jdbcTemplate.update(sql,home_policy.getClient_id(), home_policy.getMain_insured_name(), home_policy.getStart_date(), home_policy.getEnd_date(),
                home_policy.getBase_premium(), home_policy.getTax(), home_policy.getTotal_premium(), home_policy.getReplacement_cost_value(),
                home_policy.getInjury_liability_limit(), home_policy.getInjury_deductible(), home_policy.getContents_liability_limit(),
                home_policy.getContents_deductible());
    }

    @Override
    public Optional<Home_Policy> get(int id) {

        String sql = "SELECT policy_number, client_id, main_insured_name,start_date, end_date, base_premium, tax, total_premium" +
        ", replacement_cost_value, injury_liability_limit, injury_deductible, contents_liability_limit, contents_deductible FROM Home_policy " +
                "where policy_number = ?";

        Home_Policy home_policy = null;
        try {
        //    home_policy = jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
            home_policy = jdbcTemplate.queryForObject(sql,rowMapper, id);

        }
        catch (DataAccessException ex){
            //TO: meaningful errors
        }
        return Optional.ofNullable(home_policy);

    }

    @Override
    public void update(Home_Policy home_policy, int ID) {

        String sql = "update home_policy set client_id = ?, main_insured_name = ?, start_date = ?, end_date = ?, base_premium = ?, tax = ?, total_premium = ?," +
                " replacement_cost_value = ?, injury_liability_limit = ?, injury_deductible = ?, contents_liability_limit = ?, contents_deductible= ? where policy_number = ?";


        jdbcTemplate.update(sql,home_policy.getClient_id(), home_policy.getMain_insured_name(), home_policy.getStart_date(), home_policy.getEnd_date(), home_policy.getBase_premium(), home_policy.getTax(),
                home_policy.getTotal_premium(), home_policy.getReplacement_cost_value(), home_policy.getInjury_liability_limit(), home_policy.getInjury_deductible(), home_policy.getContents_liability_limit(),
                home_policy.getContents_deductible());

    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("delete from home_policy where policy_number = ?", id);
    }
}
