package com.insuranceproject.insurancesales.model;


import java.sql.Date;

/**
 * a class that represents the Home table.
 */

//TODO : Implement controller, DAO interface and data access service

public class Home {

    private int Home_id;
    private int policy_number;
    private Date date_built;
    private String type_of_dwelling;
    private String heating_type;


    public int getHome_id() {
        return Home_id;
    }

    public void setHome_id(int home_id) {
        Home_id = home_id;
    }

    public int getPolicy_number() {
        return policy_number;
    }

    public void setPolicy_number(int policy_number) {
        this.policy_number = policy_number;
    }

    public Date getDate_built() {
        return date_built;
    }

    public void setDate_built(Date date_built) {
        this.date_built = date_built;
    }

    public String getType_of_dwelling() {
        return type_of_dwelling;
    }

    public void setType_of_dwelling(String type_of_dwelling) {
        this.type_of_dwelling = type_of_dwelling;
    }

    public String getHeating_type() {
        return heating_type;
    }

    public void setHeating_type(String heating_type) {
        this.heating_type = heating_type;
    }


}
