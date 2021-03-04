package com.insuranceproject.insurancesales.dao;

import com.insuranceproject.insurancesales.model.Client;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * This class implements the behaviour of the DAO interface for Client objects.
 */

@Component
public class ClientJDBCDAO implements DAO<Client> {

    private JdbcTemplate jdbcTemplate;

    RowMapper<Client> rowMapper = (rs, rowNum) -> {
        Client client = new Client();
        client.setClient_id(rs.getInt("Client_ID"));
        client.setMain_insured_name(rs.getString("main_insured_name"));
        client.setAuto_policy_number(rs.getInt("auto_policy_number"));
        client.setAddress(rs.getString("address"));
        return client;
    };

    public ClientJDBCDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Client> list() {
        String sql = "SELECT client_id, main_insured_name, home_policy_number, auto_policy_number, address FROM client";
        return jdbcTemplate.query(sql,rowMapper);
    }

    @Override
    public void create(Client client) {
        String sql = "insert into client(main_insured_name, home_policy_number, auto_policy_number,address) values (?,?,?,?)";
        jdbcTemplate.update(sql,client.getMain_insured_name(), client.getHome_policy_number(), client.getAuto_policy_number(), client.getAddress());
    }

    @Override
    public Optional<Client> get(int id) {
        String sql = "Select client_id, main_insured_name, home_policy_number, auto_policy_number,address FROM client WHERE client_id = ?";
        Client client = null;
        try {
            client = jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
        }
        catch (DataAccessException ex){
            //TO: meaningful errors
        }
        return Optional.ofNullable(client);
    }

    @Override
    public void update(Client client, int ID) {
        String sql = "update client set main_insured_name =  ?, home_policy_number = ?, auto_policy_number = ?,address = ? WHERE client_id = ?";
        jdbcTemplate.update(sql,client.getMain_insured_name(), client.getHome_policy_number(), client.getAuto_policy_number(), client.getAddress());
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("delete from client where client_id = ?", id);
    }
}
