package com.insuranceproject.insurancesales.dao;


import com.insuranceproject.insurancesales.model.DriverRiskFactors;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DriverRiskFactorsJDBCDAO implements DAO<DriverRiskFactors> {

    private JdbcTemplate jdbcTemplate;

    RowMapper<DriverRiskFactors> rowMapper = (rs, rowNum) -> {
        DriverRiskFactors driverRiskFactors = new DriverRiskFactors();
        driverRiskFactors.setDriverAge(rs.getDate("client_birthday"));
        driverRiskFactors.setVehicleAge(rs.getInt("vehicle_year"));
        driverRiskFactors.setAccidentCount(rs.getInt("accident_id"));
        return driverRiskFactors;
    };

    public DriverRiskFactorsJDBCDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<DriverRiskFactors> list() {
        String sql = """

                select client_birthday, vehicle_year,  (
                select
        COUNT(AT_FAULT)
        from
                accident_listing
        where
        accident_date >= CURRENT_DATE - INTERVAL 5 YEAR
        AND at_fault = 1
        and client_id = main.client_id
   )
        as accident_id
        from CLIENT, accident_listing main, policy_holder, policy, auto_policy, car
        WHERE main.client_id = client.client_id AND client.auto_policy_number = policy_holder.policy_number AND policy.policy_number = policy_holder.policy_number
        AND auto_policy.policy_number = policy.policy_number AND auto_policy.VIN_NUMBER = CAR.vin_number""";
        return jdbcTemplate.query(sql,rowMapper);



    }

    @Override
    public void create(DriverRiskFactors driverRiskFactors) {

    }

    @Override
    public Optional<DriverRiskFactors> get(int id) {

        //Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //String username = authentication.getName();

        String sql = """

                select client_birthday, vehicle_year,  (
                select
        COUNT(AT_FAULT)
        from
                accident_listing
        where
        accident_date >= CURRENT_DATE - INTERVAL 5 YEAR
        AND at_fault = 1
        and client_id = main.client_id
   )
        as accident_id
        from CLIENT, accident_listing main, policy_holder, policy, auto_policy, car
        WHERE main.client_id = client.client_id AND client.auto_policy_number = policy_holder.policy_number AND policy.policy_number = policy_holder.policy_number
        AND auto_policy.policy_number = policy.policy_number AND auto_policy.VIN_NUMBER = CAR.vin_number""";

        DriverRiskFactors driverRiskFactors = null;
        try {
            driverRiskFactors = jdbcTemplate.queryForObject(sql /*, new Object[]{username}*/, rowMapper);
        }
        catch (DataAccessException ex){
            //TO: meaningful errors
        }
        return Optional.ofNullable(driverRiskFactors);



    }

    @Override
    public void update(DriverRiskFactors object, int ID) {

    }

    @Override
    public void delete(int id) {

    }
}
