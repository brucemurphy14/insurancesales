package com.insuranceproject.insurancesales.model;

/**
 * A class that represents the auto_policy table.
 */

import java.sql.Date;
import java.util.UUID;

//TODO : Implement controller, DAO interface and data access service
public class Auto_Policy {

    private int policy_number;
    private UUID client_id;
    private String main_insured_name;
    private Date start_date;
    private Date end_date;
    private float base_premium;
    private float tax;
    private float total_premium;
    private float driver_age;
    private int number_of_accidents_last_5_years;
    private String address;

}
