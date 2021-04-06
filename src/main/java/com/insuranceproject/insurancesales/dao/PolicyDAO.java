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

        String sql = "insert into policy(client_id,policy_type, /* term_price,*/ start_date) values ((select client_id from client where username = 'rfw'/*" +  "'" + username + "'" + "*/)" + " ,?, (select NOW()))" ;
        //String sql = "insert into policy(client_id, policy_type, term_price, start_date) values (?,?,?, ?)";
        jdbcTemplate.update(sql,/* policy.getClient_id(),*/ policy.getPolicy_type()/*, policy.getTerm_price()*//*, policy.getStart_date()*/);

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
        String sql = "update policy set policy_number =  ?, client_id = ?, policy_type = ?, term_price = ?, start_date = ? WHERE policy_number = ?";
        jdbcTemplate.update(sql,policy.getPolicy_number(), policy.getClient_id(), policy.getPolicy_type(), policy.getTerm_price(), policy.getStart_date());
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("delete from policy where policy_number = ?", id);
    }
}