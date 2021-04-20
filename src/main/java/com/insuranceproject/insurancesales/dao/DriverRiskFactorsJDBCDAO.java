package com.insuranceproject.insurancesales.dao;

import com.insuranceproject.insurancesales.model.DriverRiskFactors;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

/**
 * This DAO retrieves client auto risk factors for policy calculation cost.
 */
@Component
public class DriverRiskFactorsJDBCDAO implements DAO<DriverRiskFactors> {

    private JdbcTemplate jdbcTemplate;

    RowMapper<DriverRiskFactors> rowMapper = (rs, rowNum) -> {
        DriverRiskFactors driverRiskFactors = new DriverRiskFactors();
        driverRiskFactors.setDriverAge(rs.getInt("client_age"));
        driverRiskFactors.setVehicleAge(rs.getInt("vehicle_year"));
        driverRiskFactors.setAccidentCount(rs.getInt("at_fault_accident_count"));
        driverRiskFactors.setVehicleWorth(rs.getFloat("vehicle_worth"));
        driverRiskFactors.setLocation_type(rs.getString("location_type"));
        return driverRiskFactors;
    };

    public DriverRiskFactorsJDBCDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<DriverRiskFactors> list() {
        String sql = """
                select location_type, TIMESTAMPDIFF (YEAR, client_birthday, CURDATE() ) as client_age , vehicle_year,  (
                select
        COUNT(AT_FAULT)
        from
                accident_listing
        where
        accident_date >= CURRENT_DATE - INTERVAL 5 YEAR
        AND at_fault = 1
        and client_id = main.client_id
   )
        as at_fault_accident_count, vehicle_worth
        from CLIENT, accident_listing main, policy_holder, policy, auto_policy, car, address
        WHERE main.client_id = client.client_id AND client.auto_policy_number = policy_holder.policy_number AND policy.policy_number = policy_holder.policy_number
        AND auto_policy.policy_number = policy.policy_number AND auto_policy.VIN_NUMBER = CAR.vin_number and address.address_id = client.address_id""";
        return jdbcTemplate.query(sql,rowMapper);



    }

    @Override
    public void create(DriverRiskFactors driverRiskFactors) {

    }

    @Override
    public int createAndReturnAutoKey(DriverRiskFactors driverRiskFactors) {
        return 0;
    }


    @Override
    public Optional<DriverRiskFactors> get(int id) {
        //Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //String username = authentication.getName();
        String sql = """              
                select DISTINCT location_type, TIMESTAMPDIFF (YEAR, CLIENT_Birthday, CURDATE() ) as client_age , vehicle_year,  (
                select
        COUNT(AT_FAULT)
        from
                accident_listing
        where
        accident_date >= CURRENT_DATE - INTERVAL 5 YEAR
        AND at_fault = 1
        and client_id = main.client_id
   )
        as at_fault_accident_count, vehicle_worth
        from CLIENT, accident_listing main, policy_holder, policy, auto_policy, car, address
        WHERE main.client_id = client.client_id AND client.auto_policy_number = policy_holder.policy_number AND policy.policy_number = policy_holder.policy_number
        AND auto_policy.policy_number = policy.policy_number AND auto_policy.VIN_NUMBER = CAR.vin_number and  client.client_id = ? and address.address_id = client.address_id""";

        DriverRiskFactors driverRiskFactors = null;
        try {
            driverRiskFactors = jdbcTemplate.queryForObject(sql , new Object[]{id},  rowMapper);
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
