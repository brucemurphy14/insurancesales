package com.insuranceproject.insurancesales.model;

import java.sql.Date;
import java.util.UUID;

/**
 * A class that represents the home_policy table.
 */

//TODO : Implement controller, DAO interface and data access service

public class Home_Policy {
    private int policy_number;
    private UUID client_id;
    private String main_insured_name;
    private String other_insured_names;
    private Date start_date;
    private Date end_date;
    private float base_premium;
    private float tax;
    private float total_premium;
    private float replacement_cost_value;
    private float injury_liability_limit;
    private float injury_deductible;
    private float contents_liability_limit;
    private float contents_deductible;

}
