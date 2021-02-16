package com.insuranceproject.insurancesales.dao;

import com.insuranceproject.insurancesales.model.Home;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;
import java.util.Optional;

//TODO implement interface methods
public class HomeJDBCDAO implements DAO<Home>{

    private JdbcTemplate jdbcTemplate;


    RowMapper<Home> rowMapper = (rs, rowNum) -> {
        Home home = new Home();
        home.setPolicy_number(rs.getInt("policy_number"));
        home.setAge_since_built(rs.getInt("age_since_built"));
        home.setType_of_dwelling(rs.getString("type_of_dwellings"));
        home.setHeating_type(rs.getString("heating_type"));
        return home;
    };

    public HomeJDBCDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Home> list() {
        String sql = "SELECT policy_number, age_since_built, type_of_dwelling, heating_type FROM home";
        return jdbcTemplate.query(sql,rowMapper);
    }

    @Override
    public void create(Home home) {
        String sql = "insert into HOME(age_since_built, type_of_dwelling, heating_type) values (?,?,?)";
        jdbcTemplate.update(sql, home.getAge_since_built(), home.getType_of_dwelling(), home.getHeating_type());


    }

    @Override
    public Optional<Home> get(int id) {

        String sql = "Select policy_number, age_since_built, type_of_dwelling, heating_type FROM home WHERE policy_number = ?";
        Home home = null;
        try {
            home = jdbcTemplate.queryForObject(sql,rowMapper, id);
        }
        catch (DataAccessException ex){
            //TO: meaningful errors
        }
        return Optional.ofNullable(home);
    }

    @Override
    public void update(Home home, int ID) {

        String sql = "update home set age_since_built =  ?, type_of_dwelling = ?, heating_type = ? WHERE policy_number = ?";
        jdbcTemplate.update(sql,home.getAge_since_built(), home.getType_of_dwelling(), home.getHeating_type());

    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("delete from home where policy_number = ?", id);
    }
}
