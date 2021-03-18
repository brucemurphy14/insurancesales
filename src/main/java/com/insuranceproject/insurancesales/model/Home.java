package com.insuranceproject.insurancesales.model;


/**
 * a class that represents the Home table.
 */

//TODO : Implement controller, DAO interface and data access service

public class Home {

    private int Home_id;
    private int policy_number;
    private int age_since_built;
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

    public int getAge_since_built() {
        return age_since_built;
    }

    public void setAge_since_built(int age_since_built) {
        this.age_since_built = age_since_built;
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
