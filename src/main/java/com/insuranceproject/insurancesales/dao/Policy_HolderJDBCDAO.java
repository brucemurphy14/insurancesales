package com.insuranceproject.insurancesales.dao;

import com.insuranceproject.insurancesales.api.PolicyPriceCreator;
import com.insuranceproject.insurancesales.model.Policy_Holder;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class Policy_HolderJDBCDAO implements DAO<Policy_Holder> {

    private final JdbcTemplate jdbcTemplate;

    RowMapper<Policy_Holder> rowMapper = (rs, rowNum) -> {
        Policy_Holder policy_holder = new Policy_Holder();
       // policy_holder.setPolicy_holder_id(rs.getInt("policy_holder_id"));
        policy_holder.setPolicy_number(rs.getInt("policy_number"));
        policy_holder.setClient_id(rs.getInt("client_id"));
        return policy_holder;
    };

    public Policy_HolderJDBCDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Policy_Holder> list() {
        String sql = "SELECT /*policy_holder_id,*/ policy_number, client_id FROM policy_holder";
        return jdbcTemplate.query(sql,rowMapper);
    }

    @Override
    public void create(Policy_Holder policy_holder) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
       // String sql = "insert into policy_holder(policy_number, client_id) values (?,?)";
         String sql = "insert into policy_holder(policy_number, client_id) values ((select MAX(policy_number)), (select client_id from client where username =" +  "'" + username + "'" + "))";

        jdbcTemplate.update(sql/*, policy_holder.getPolicy_number(), policy_holder.getClient_id()*/);
    }

    public void createNoParam() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
      //  System.out.println(username);
        // String sql = "insert into policy_holder(policy_number, client_id) values (?,?)";
        String sql = "insert into policy_holder(policy_number, client_id) values ((select MAX(policy_number) from policy), (select client_id from client where username = " +  "'" + username + "'" + "))";
        jdbcTemplate.update(sql/*, policy_holder.getPolicy_number(), policy_holder.getClient_id()*/);
    }



    @Override
    public int createAndReturnAutoKey(Policy_Holder policy_holder) {
        return 0;
    }

    @Override
    public Optional<Policy_Holder> get(int id) {
        String sql = "SELECT /*policy_holder_id,*/ policy_number, client_id FROM policy_holder /*WHERE policy_holder_id = ?*/";
        Policy_Holder policy_holder = null;
        try {
            policy_holder = jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
        }
        catch (DataAccessException ex){
            //TO: meaningful errors
        }
        return Optional.ofNullable(policy_holder);
    }

    @Override
    public void update(Policy_Holder object, int ID) {

    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("delete from policy_holder where policy_holder_id = ?", id);
    }
}