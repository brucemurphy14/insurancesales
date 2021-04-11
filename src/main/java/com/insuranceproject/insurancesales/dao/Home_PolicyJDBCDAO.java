package com.insuranceproject.insurancesales.dao;

import com.insuranceproject.insurancesales.model.Home_Policy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * This DAO class retrieves the data from the home_policy table.
 */
@Component
public class Home_PolicyJDBCDAO implements DAO<Home_Policy> {
//TODO implement interface methods
    @Autowired
    private JdbcTemplate jdbcTemplate;

    RowMapper<Home_Policy> rowMapper = (rs, rowNum) -> {
        Home_Policy homePolicy = new Home_Policy();
        homePolicy.setPolicy_number(rs.getInt("policy_number"));
        homePolicy.setClient_id(rs.getInt("client_id"));
        homePolicy.setHome_id(rs.getInt("home_id"));
        return homePolicy;
    };


    @Override
    public List<Home_Policy> list() {
        String sql = "SELECT policy_number, client_id, home_id FROM Home_policy";
        return jdbcTemplate.query(sql,rowMapper);

    }

    @Override
    public void create(Home_Policy home_policy) {
     /*   String sql = "Insert into Home_policy(policy_number, client_id, home_id)" +
                 " values(?,?,?)";*/
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        String sql = "Insert into Home_policy(policy_number, client_id, home_id)" +
                " values((SELECT MAX(policy_number) FROM POLICY) ,(select client_id from client where username = 'rfw'/*" +  "'" + username + "'" + "*/)"+ " , (SELECT MAX(HOME_ID) from home))";


        jdbcTemplate.update(sql /*home_policy.getPolicy_number()*//* ,home_policy.getClient_id(),*//* home_policy.getHome_id()*/ );
    }

    public void createNoParam() {
     /*   String sql = "Insert into Home_policy(policy_number, client_id, home_id)" +
                 " values(?,?,?)";*/
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        String sql = "Insert into Home_policy(policy_number, client_id, home_id)" +
                " values((SELECT MAX(policy_number) FROM POLICY) ,(select client_id from client where username =" +  " '" + username + "'" + ")"+ ", (SELECT MAX(HOME_ID) from home))";


        jdbcTemplate.update(sql /*home_policy.getPolicy_number()*//* ,home_policy.getClient_id(),*//* home_policy.getHome_id()*/ );
    }




    @Override
    public int createAndReturnAutoKey(Home_Policy home_policy) {
        return 0;
    }

    @Override
    public Optional<Home_Policy> get(int id) {

        String sql = "SELECT policy_number, client_id, home_id  FROM Home_policy where policy_number = ?";

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

        String sql = "update home_policy set policy_number = ? , client_id = ? where home_id = ?";

        jdbcTemplate.update(sql,home_policy.getPolicy_number(), home_policy.getClient_id(), home_policy.getHome_id());

    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("delete from home_policy where policy_number = ?", id);
    }
}
