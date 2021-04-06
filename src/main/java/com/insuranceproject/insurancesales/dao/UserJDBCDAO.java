package com.insuranceproject.insurancesales.dao;

import com.insuranceproject.insurancesales.model.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * This DAO retrieves data from the home table.
 */
@Component
public class UserJDBCDAO implements DAO<User>{

    private JdbcTemplate jdbcTemplate;

    RowMapper<User> rowMapper = (rs, rowNum) -> {
        User user = new User();
        user.setUser_id(rs.getInt("user_id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setRole(rs.getString("role"));
        user.setEnabled(rs.getBoolean("enabled"));
        return user;
    };

    public UserJDBCDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> list() {
        String sql = "SELECT  user_id, username, password, role, enabled FROM users";
        return jdbcTemplate.query(sql,rowMapper);
    }

    @Override
    public void create(User user) {
        String sql = "insert into users(username, password, role, enabled) values (?,?,'CLIENT',1)";
        jdbcTemplate.update(sql,user.getUsername(), user.getPassword()/*, user.getRole(), user.isEnabled()*/);
    }

    @Override
    public int createAndReturnAutoKey(User user) {
        return 0;
    }

    @Override
    public Optional<User> get(int id) {

        String sql = "Select user_id, username, password, role, enabled FROM users WHERE username = ?";
        User user = null;
        try {
            user = jdbcTemplate.queryForObject(sql,rowMapper, id);
        }
        catch (DataAccessException ex){
            //TO: meaningful errors
        }
        return Optional.ofNullable(user);
    }

    @Override
    public void update(User home, int ID) {

        /*
        String sql = "update home set date_built =  ?, type_of_dwelling = ?, heating_type = ? WHERE policy_number = ?";
        jdbcTemplate.update(sql,home.getDate_built(), home.getType_of_dwelling(), home.getHeating_type());
*/
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("delete from user where policy_number = ?", id);
    }
}
