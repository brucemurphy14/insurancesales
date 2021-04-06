package com.insuranceproject.insurancesales.dao;

import com.insuranceproject.insurancesales.model.HomeRiskFactors;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

/**
 * This DAO class accesses the database for risk factors for home insurance policies.
 */
@Component
public class HomeRiskFactorsJDBCDAO implements DAO<HomeRiskFactors> {

    private JdbcTemplate jdbcTemplate;

    RowMapper<HomeRiskFactors> rowMapper = (rs, rowNum) -> {
        HomeRiskFactors homeRiskFactors = new HomeRiskFactors();
        homeRiskFactors.setHomeAge(rs.getInt("date_built"));
        homeRiskFactors.setDwellingType(rs.getString("type_of_dwelling"));
        homeRiskFactors.setHeatingType(rs.getString("heating_type"));
        return homeRiskFactors;
    };

    public HomeRiskFactorsJDBCDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<HomeRiskFactors> list() {
        String sql = """ 
        select TIMESTAMPDIFF(YEAR, date_built, CURDATE()) as date_built , heating_type, type_of_dwelling
        from home,client, policy, home_policy, policy_holder
        WHERE client.client_id = policy_holder.client_id
        AND policy.policy_number = policy_holder.policy_number
        AND home_policy.policy_number = policy.policy_number
        AND  home_policy_number = home_policy.policy_number""";

        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public void create(HomeRiskFactors homeRiskFactors) {

    }

    @Override
    public int createAndReturnAutoKey(HomeRiskFactors homeRiskFactors) {
        return 0;
    }

    @Override
    public Optional<HomeRiskFactors> get(int id) {

        String sql = """ 
        select TIMESTAMPDIFF(YEAR, date_built, CURDATE()) as date_built, heating_type, type_of_dwelling
        from home,client, policy, home_policy, policy_holder
        WHERE client.client_id = policy_holder.client_id
        AND policy.policy_number = policy_holder.policy_number
        AND home_policy.policy_number = policy.policy_number
        AND  home_policy_number = home_policy.policy_number AND client.client_id = ?""";

        HomeRiskFactors homeRiskFactors = null;
        try {
            homeRiskFactors = jdbcTemplate.queryForObject(sql , new Object[]{id},  rowMapper);
        }
        catch (DataAccessException ex){
            //TO: meaningful errors
        }

        return Optional.ofNullable(homeRiskFactors);



    }

    @Override
    public void update(HomeRiskFactors object, int ID) {

    }

    @Override
    public void delete(int id) {

    }
}
