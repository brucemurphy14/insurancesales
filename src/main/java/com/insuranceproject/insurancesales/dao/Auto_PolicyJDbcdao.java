package com.insuranceproject.insurancesales.dao;

import com.insuranceproject.insurancesales.model.Auto_Policy;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class Auto_PolicyJDbcdao implements DAO<Auto_Policy> {

    private JdbcTemplate jdbcTemplate;

    RowMapper<Auto_Policy> rowMapper = (rs, rowNum) -> {
        Auto_Policy auto_policy = new Auto_Policy();
        auto_policy.setClient_id(rs.getInt("Client_ID"));
        auto_policy.setMain_insured_name(rs.getString("main_insured_name"));
        auto_policy.setStart_date(rs.getDate("start_date"));
        auto_policy.setEnd_date(rs.getDate("end_date"));
        auto_policy.setBase_premium(rs.getFloat("base_premium"));
        auto_policy.setTotal_premium(rs.getFloat("total_premium"));
        auto_policy.setTax(rs.getFloat("tax"));
        auto_policy.setNumber_of_accidents_last_5_years(rs.getInt("number_of_accidents_last_5_years"));
        auto_policy.setAddress(rs.getString("address"));
        return auto_policy;
    };


    @Override
    public List<Auto_Policy> list() {
        String sql = "SELECT policy_number, client_id, main_insured_name, start_date, end_date, base_premium," +
                "tax, total_premium, driver_age, number_of_accidents_last_5_years,address FROM auto_policy";
        return jdbcTemplate.query(sql,rowMapper);
    }

    @Override
    public void create(Auto_Policy auto_policy) {
        String sql = "insert into auto_policy(client_id, main_insured_name, start_date,end_date, base_premium," +
                "tax, total_premium, driver_age, number_of_accidents_last_5_years, address) values (?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql,auto_policy.getClient_id(), auto_policy.getMain_insured_name(), auto_policy.getStart_date(),
                auto_policy.getEnd_date(), auto_policy.getBase_premium(), auto_policy.getTax(), auto_policy.getTotal_premium(), auto_policy.getDriver_age()
        ,auto_policy.getNumber_of_accidents_last_5_years(), auto_policy.getAddress());
    }

    @Override
    public Optional<Auto_Policy> get(int id) {

        String sql = "SELECT policy_number, client_id, main_insured_name, start_date, end_date, base_premium,tax, total_premium, " +
                "driver_age, number_of_accidents_last_5_years,address FROM auto_policy WHERE policy_number = ?";
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
        String sql = "update auto_policy set client_id = ?, main_insured_name = ?, start_date = ?, end_date = ?, base_premium = ?,tax = ?, total_premium = ?, " +
                "driver_age = ?, number_of_accidents_last_5_years = ?,address = ? WHERE policy_number = ?";
        jdbcTemplate.update(sql,auto_policy.getClient_id(), auto_policy.getMain_insured_name(), auto_policy.getStart_date(), auto_policy.getEnd_date()
        , auto_policy.getBase_premium(), auto_policy.getTax(), auto_policy.getTotal_premium(), auto_policy.getDriver_age(), auto_policy.getNumber_of_accidents_last_5_years()
        , auto_policy.getAddress());



    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("delete from auto_policy where policy_number = ?", id);
    }
}
