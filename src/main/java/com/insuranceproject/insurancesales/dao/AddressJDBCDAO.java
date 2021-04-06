package com.insuranceproject.insurancesales.dao;

import com.insuranceproject.insurancesales.model.Address;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AddressJDBCDAO implements DAO<Address>{


    private final JdbcTemplate jdbcTemplate;

    RowMapper<Address> rowMapper = (rs, rowNum) -> {
        Address address = new Address();
        address.setAddress_id(rs.getInt("address_id"));
        address.setStreet_address(rs.getString("street_address"));
        address.setProvince(rs.getString("province"));
        address.setCity(rs.getString("city"));
        address.setZip_code(rs.getString("zip_code"));
        address.setLocation_type(rs.getString("location_type"));
        return address;
    };

    public AddressJDBCDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Address> list() {
        String sql = "SELECT address_id, street_address, province, city, zip_code, location_type FROM address";
        return jdbcTemplate.query(sql,rowMapper);
    }

    @Override
    public void create(Address address) {
        String sql = "insert into address(street_address, province, city, zip_code, location_type) values (?,?,?,?,?)";
        jdbcTemplate.update(sql, address.getStreet_address(), address.getProvince(), address.getCity(), address.getZip_code(), address.getLocation_type());
        String sql2 = "SELECT LAST_INSERT_ID()";
        System.out.println(jdbcTemplate.queryForObject(sql2, Integer.class));
    }

    @Override
    public int createAndReturnAutoKey(Address address) {
        String sql = "insert into address(street_address, province, city, zip_code, location_type) values (?,?,?,?,?)";
        jdbcTemplate.update(sql, address.getStreet_address(), address.getProvince(), address.getCity(), address.getZip_code(), address.getLocation_type());
        String sql2 = "SELECT LAST_INSERT_ID()";
        return jdbcTemplate.queryForObject(sql2, Integer.class);
    }

    @Override
    public Optional<Address> get(int id) {
        String sql = "SELECT address_id, street_address, province, city, zip_code, location_type FROM address WHERE address_id = ?";
        Address address = null;
        try {
            address = jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
        }
        catch (DataAccessException ex){
            //TO: meaningful errors
        }
        return Optional.ofNullable(address);
    }

    @Override
    public void update(Address object, int ID) {

    }



    @Override
    public void delete(int id) {
        jdbcTemplate.update("delete from address where address_id = ?", id);
    }
}
