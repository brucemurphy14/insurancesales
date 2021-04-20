package com.insuranceproject.insurancesales.dao;

import com.insuranceproject.insurancesales.model.Client;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.activation.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

/**
 * This DAO class handles interactions with the client table.
 */

@Component
public class ClientJDBCDAO implements DAO<Client> {

    private  JdbcTemplate jdbcTemplate;

    RowMapper<Client> rowMapper = (rs, rowNum) -> {
        Client client = new Client();
        client.setClient_id(rs.getInt("Client_ID"));
        client.setMain_insured_first_name(rs.getString("main_insured_first_name"));
        client.setMain_insured_last_name(rs.getString("main_insured_last_name"));
        client.setAuto_policy_number(rs.getInt("auto_policy_number"));
        client.setHome_policy_number(rs.getInt("home_policy_number"));
        client.setAddress_id(rs.getInt("address_id"));
        client.setUsername(rs.getString("username"));
        client.setClient_birthday(rs.getDate("client_birthday"));
        return client;
    };

    public ClientJDBCDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Client> list() {

        String sql = "SELECT client_id, main_insured_first_name,main_insured_last_name, home_policy_number, auto_policy_number, address_id,username, client_birthday FROM client";
        return jdbcTemplate.query(sql,rowMapper);
    }

    @Override
    public void create(Client client) {
        String nextClient = "SELECT MAX(client_id)+1 FROM CLIENT";
        String sql = "insert into client(main_insured_first_name,main_insured_last_name,/*  home_policy_number, auto_policy_number,*/ address_id, username,client_birthday) values (?,?,(SELECT MAX(address_id) from address),(select username from users where user_id = (select max(user_id) from users)) ,?)";
        jdbcTemplate.update(sql,client.getMain_insured_first_name(),client.getMain_insured_last_name(),/* client.getHome_policy_number(), client.getAuto_policy_number() ,*/ /*client.getAddress_id(),*/ /*client.getUsername(),*/ client.getClient_birthday());
        int nextClientKey = jdbcTemplate.queryForObject("SELECT MAX(client_id) FROM CLIENT", Integer.class);
        System.out.println(nextClientKey);
    }

    @Override
    public int createAndReturnAutoKey(Client client) {
        String nextClient = "SELECT MAX(client_id)+1 FROM CLIENT";
        String sql = "insert into client(main_insured_first_name,main_insured_last_name,  home_policy_number, auto_policy_number,address_id, username,client_birthday) values (?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql,client.getMain_insured_first_name(),client.getMain_insured_last_name(), client.getHome_policy_number(), client.getAuto_policy_number(), client.getAddress_id(), client.getUsername(), client.getClient_birthday());
        int nextClientKey = jdbcTemplate.queryForObject("SELECT MAX(client_id) FROM CLIENT", Integer.class);
        return nextClientKey;
    }

    public void updatePolicyField(int client_id, String policyType, int policyNumber){
        String sql = null;
        if (policyType.equals("Auto")) {
             sql = "update client set auto_policy_number = ? WHERE client_id = ?";
        }
        else if (policyType.equals("Home")) {
             sql = "update client set home_policy_number = ? WHERE client_id = ?";
        }
        jdbcTemplate.update(sql,policyNumber, client_id);
    }

    @Override
    public Optional<Client> get(int id) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();


      //  System.out.println(username);


        String sql = "Select client_id, main_insured_first_name,main_insured_last_name, home_policy_number, auto_policy_number,address_id, username, client_birthday FROM client  WHERE username = " + "'" + username + "'";
        //String sql = "Select client_id, main_insured_first_name,main_insured_last_name, home_policy_number, auto_policy_number,address_id, username, client_birthday FROM client WHERE client_id = ?";

      //  System.out.println(sql);

        Client client = null;
        try {

            client = jdbcTemplate.queryForObject(sql /*,new Object[]{username} */ , /*, new Object[]{id} ,*/ rowMapper);
        }
        catch (DataAccessException ex){
            //TO: meaningful errors
        }
        return Optional.ofNullable(client);
    }

    @Override
    public void update(Client client, int ID) {
        String sql = "update client set main_insured_first_name =  ?,main_insured_last_name = ?, client_birthday = ? WHERE client_id = " + ID;
        jdbcTemplate.update(sql,client.getMain_insured_first_name(),client.getMain_insured_last_name(),client.getClient_birthday());
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("delete from client where client_id = ?", id);
    }

    /**
     * After a new row is inserted in policy_holder, updated the insurance number in the client table.
     * @param policyType
     */
    public void updateInsuranceNumberClient(String policyType) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        if (policyType.equals("Home")) {
            String sql = "update client set home_policy_number = (select max(policy_number) from policy ) where username = "+username;
            jdbcTemplate.update(sql);
        }

        else if (policyType.equals("Auto")) {
            String sql = "update client set auto_policy_number = (select max(policy_number) from policy ) where username = "+username;
            jdbcTemplate.update(sql);
        }
    }

    public int returnCurrentClientID(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        String sql = "SELECT client_id FROM CLIENT WHERE username = " + "'"+ currentPrincipalName + "'";
        return jdbcTemplate.queryForObject(sql , Integer.class);
    }
}
