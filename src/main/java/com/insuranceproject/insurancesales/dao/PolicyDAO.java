package com.insuranceproject.insurancesales.dao;


import com.insuranceproject.insurancesales.model.Policy;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PolicyDAO implements DAO<Policy> {


    private final JdbcTemplate jdbcTemplate;

    RowMapper<Policy> rowMapper = (rs, rowNum) -> {
        Policy policy = new Policy();
        policy.setPolicy_number(rs.getInt("policy_number"));
        policy.setClient_id(rs.getInt("client_id"));
        policy.setPolicy_type(rs.getString("policy_type"));
        policy.setTerm_price(rs.getFloat("term_price"));
        policy.setStart_date(rs.getDate("start_date"));
        return policy;
    };

    public PolicyDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Policy> list() {
        String sql = "SELECT policy_number, client_id, policy_type, term_price, start_date FROM policy";
        return jdbcTemplate.query(sql,rowMapper);
    }

    @Override
    public  void create(Policy policy) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        System.out.println(username);

        String sql = "insert into policy(client_id,policy_type, /* term_price,*/ start_date) values ((select client_id from client where username =" +  "'" + username + "'" + ")" + " ,?, (select NOW()))" ;
        //String sql = "insert into policy(client_id, policy_type, term_price, start_date) values (?,?,?, ?)";
        jdbcTemplate.update(sql,/* policy.getClient_id(),*/ policy.getPolicy_type()/*, policy.getTerm_price()*//*, policy.getStart_date()*/);

    }

    public Policy getUserAutoPolicy(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        String sql = "select client_id, policy_number,policy_type, term_price, start_date FROM policy where client_id = (select client_id from client where username =" +  "'" + username + "'" + ")" + "AND policy_type = 'Auto'";
        try {
            return jdbcTemplate.queryForObject(sql, rowMapper);
        }
        catch (DataAccessException e){
            return null;
        }
    }

    public Policy getUserHomePolicy(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        String sql = "select client_id, policy_number,policy_type, term_price, start_date FROM policy where client_id = (select client_id from client where username =" +  "'" + username + "'" + ")" + "AND policy_type = 'Home'";
        try {
            return jdbcTemplate.queryForObject(sql, rowMapper);
        }
        catch (DataAccessException e){
            return null;
        }
    }


    @Override
    public int createAndReturnAutoKey(Policy policy) {
        return 0;
    }

    @Override
    public Optional<Policy> get(int id) {
        String sql = "SELECT policy_number, client_id, policy_type, term_price, start_date FROM policy WHERE client_id = ?";
        Policy policy = null;
        try {
            policy = jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
        }
        catch (DataAccessException ex){
            //TO: meaningful errors
        }
        return Optional.ofNullable(policy);
    }

    @Override
    public void update(Policy policy, int ID) {
        //String sql = "update policy set policy_number =  ?, client_id = ?, policy_type = ?, term_price = ?, start_date = ? WHERE policy_number = ?";
        String sql = "update policy set term_price = ? WHERE policy_number = ?";

        //jdbcTemplate.update(sql,policy.getPolicy_number(), policy.getClient_id(), policy.getPolicy_type(), policy.getTerm_price(), policy.getStart_date());
        jdbcTemplate.update(sql,policy.getTerm_price(), policy.getPolicy_number());
    }

    public void updateTermPrice(float termPrice, int policyID) {
        //String sql = "update policy set policy_number =  ?, client_id = ?, policy_type = ?, term_price = ?, start_date = ? WHERE policy_number = ?";
        String sql = "update policy set term_price = ? WHERE policy_number = ?";

        //jdbcTemplate.update(sql,policy.getPolicy_number(), policy.getClient_id(), policy.getPolicy_type(), policy.getTerm_price(), policy.getStart_date());
        jdbcTemplate.update(sql,termPrice, policyID);
    }

    public void update(Float termPrice) {
        //String sql = "update policy set policy_number =  ?, client_id = ?, policy_type = ?, term_price = ?, start_date = ? WHERE policy_number = ?";
        String sql = "update policy set term_price = ? WHERE policy_number = (select MAX(policy.policy_number))";

        //jdbcTemplate.update(sql,policy.getPolicy_number(), policy.getClient_id(), policy.getPolicy_type(), policy.getTerm_price(), policy.getStart_date());
        jdbcTemplate.update(sql,termPrice);

    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("delete from policy where policy_number = ?", id);
    }


    public int returnNewestPolicyNumber() {
        //String sql = "update policy set policy_number =  ?, client_id = ?, policy_type = ?, term_price = ?, start_date = ? WHERE policy_number = ?";
        String sql = "select MAX(policy_number) from policy";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    public String returnNewestPolicyType() {
        //String sql = "update policy set policy_number =  ?, client_id = ?, policy_type = ?, term_price = ?, start_date = ? WHERE policy_number = ?";
        String sql = "select policy_type from policy where policy_number = (select MAX(policy_number) from policy)";
        return jdbcTemplate.queryForObject(sql, String.class);
    }
}