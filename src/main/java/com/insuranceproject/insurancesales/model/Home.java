package com.insuranceproject.insurancesales.model;

import java.sql.Date;
import java.util.UUID;

/**
 * a class that represents the Home table.
 */

//TODO : Implement controller, DAO interface and data access service

public class Home {

    private int policy_number;
    private UUID client_id;
    private int age_since_built;
    private String type_of_dwelling;
    private String heating_type;
}
