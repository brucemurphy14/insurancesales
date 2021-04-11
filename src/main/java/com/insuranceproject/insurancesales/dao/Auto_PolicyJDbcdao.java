package com.insuranceproject.insurancesales.dao;

import com.insuranceproject.insurancesales.model.Auto_Policy;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * A DAO class that handles interacting with the auto_policy table.
 */
@Component
public class Auto_PolicyJDbcdao implements DAO<Auto_Policy> {

    private JdbcTemplate jdbcTemplate;

    public Auto_PolicyJDbcdao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    RowMapper<Auto_Policy> rowMapper = (rs, rowNum) -> {
        Auto_Policy auto_policy = new Auto_Policy();
        auto_policy.setPolicy_number(rs.getInt("policy_number"));
        auto_policy.setClient_id(rs.getInt("client_id"));
        auto_policy.setVIN_number(rs.getInt("VIN_NUMBER"));
        return auto_policy;
    };


    @Override
    public List<Auto_Policy> list() {
        String sql = "SELECT policy_number, client_id, VIN_NUMBER FROM auto_policy";
        return jdbcTemplate.query(sql,rowMapper);
    }

    @Override
    public void create(Auto_Policy auto_policy) {
        //String sql = "insert into auto_policy(policy_number, client_id, VIN_NUMBER) values (?,?,?)";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        String sql = "Insert into Auto_policy(policy_number, client_id, VIN_NUMBER)" +
                " values((SELECT MAX(policy_number) FROM POLICY) ,(select client_id from client where username = 'rfw'/*" +  "'" + username + "'" + "*/)"+ " , (SELECT MAX(VIN_NUMBER) from car))";
        jdbcTemplate.update(sql/*,auto_policy.getPolicy_number(), auto_policy.getClient_id(),auto_policy.getVIN_number()*/);
    }

    public void createNoParam() {
        //String sql = "insert into auto_policy(policy_number, client_id, VIN_NUMBER) values (?,?,?)";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        String sql = "Insert into Auto_policy(policy_number, client_id, VIN_NUMBER)" +
                " values((SELECT MAX(policy_number) FROM POLICY) ,(select client_id from client where username = " +  "'" + username + "'" + ")"+ " , (SELECT MAX(VIN_NUMBER) from car))";
        jdbcTemplate.update(sql/*,auto_policy.getPolicy_number(), auto_policy.getClient_id(),auto_policy.getVIN_number()*/);
    }

    @Override
    public int createAndReturnAutoKey(Auto_Policy auto_policy) {
        return 0;
    }

    @Override
    public Optional<Auto_Policy> get(int id) {

        String sql = "SELECT policy_number, client_id, VIN_NUMBER FROM auto_policy WHERE policy_number = ?";
        Auto_Policy auto_policy = null;
        try {
            auto_policy = jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
        }
        catch (DataAccessException ex){
            //TO: meaningful errors
        }
        return Optional.ofNullable(auto_policy);
    }

    @Override
    public void update(Auto_Policy auto_policy, int ID) {
        String sql = "update auto_policy set policy_number = ?, client_id = ?, VIN_NUMBER = ? WHERE policy_number = ?";
        jdbcTemplate.update(sql,auto_policy.getPolicy_number(), auto_policy.getClient_id(), auto_policy.getVIN_number());
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("delete from auto_policy where policy_number = ?", id);
    }
}
