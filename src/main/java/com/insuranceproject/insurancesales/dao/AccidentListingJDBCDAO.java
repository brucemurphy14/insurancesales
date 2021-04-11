package com.insuranceproject.insurancesales.dao;

import com.insuranceproject.insurancesales.model.AccidentListing;
import com.insuranceproject.insurancesales.model.DriverRiskFactors;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * A DAO class that handles reading the accident_listing table values from the database.
 */
@Component
public class AccidentListingJDBCDAO implements DAO<AccidentListing>{

    private JdbcTemplate jdbcTemplate;

    RowMapper<AccidentListing> rowMapper = (rs, rowNum) -> {
        AccidentListing accidentListing = new AccidentListing();
        accidentListing.setAccident_id(rs.getInt("accident_id"));
        accidentListing.setClient_id(rs.getInt("client_id"));
        accidentListing.setAccident_date(rs.getDate("accident_date"));
        accidentListing.setAt_fault(rs.getBoolean("at_fault"));
        accidentListing.setAccidents_last_5_years(rs.getInt("totalatfaultaccidents"));
        return accidentListing;
    };

    public AccidentListingJDBCDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<AccidentListing> list() {
        //String sql = "select * from accident_listing";
        String sql2 = """
                select accident_id,
                client_id,
                accident_date,
                at_fault,
                (
                        select
        COUNT(AT_FAULT)
        from
                accident_listing
        where
        accident_date >= CURRENT_DATE - INTERVAL 5 YEAR
        AND at_fault = 1
        and client_id = main.client_id
   )
        as totalatfaultaccidents
        from
        accident_listing main""";
        return jdbcTemplate.query(sql2,rowMapper);
    }

    @Override
    public void create(AccidentListing accidentListing) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

       // String sqlcurrentclientID = "select client_id from client where username =" +  "'" + username + "'";

      //  int loggedInClientID = jdbcTemplate.queryForObject(sqlcurrentclientID, Integer.class);

       // String sql = "insert into accident_listing(client_id,accident_date,  at_fault) values ((select client_id from client where username =" +  "'" + username + "'" + ")" + " ,?,?)";
        String sql = "insert into accident_listing(client_id,accident_date,  at_fault) values ((select client_id from client where username =" + "'" +username +"'" +")" + " ,?,?)";

        jdbcTemplate.update(sql,/*accidentListing.getClient_id(),*/ accidentListing.getAccident_date(), accidentListing.isAt_fault());
    }

    @Override
    public int createAndReturnAutoKey(AccidentListing accidentListing) {
        return 0;
    }

    @Override
    public Optional<AccidentListing> get(int id) {

        //String sql = "select COUNT(AT_FAULT) from accident_listing where accident_date >= CURRENT_DATE - INTERVAL 5 YEAR AND at_fault = 1;";
        //String sql = "select * from accident_listing";
        String sql2 = "select  accident_id,client_id, accident_date, at_fault ,  (select COUNT(AT_FAULT) from accident_listing where accident_date >= CURRENT_DATE - INTERVAL 5 YEAR AND at_fault = 1) as accidents_last_5_years  from accident_listing;\n";

        AccidentListing accidentListing = null;
        try {
            accidentListing = jdbcTemplate.queryForObject(sql2 /*, new Object[]{username}*/, rowMapper);
        }
        catch (DataAccessException ex){
            //TO: meaningful errors
        }
        return Optional.ofNullable(accidentListing);
    }

    @Override
    public void update(AccidentListing object, int ID) {

    }

    @Override
    public void delete(int id) {

    }
}
