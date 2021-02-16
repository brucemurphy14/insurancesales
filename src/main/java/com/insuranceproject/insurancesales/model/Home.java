package com.insuranceproject.insurancesales.model;


/**
 * a class that represents the Home table.
 */

//TODO : Implement controller, DAO interface and data access service

public class Home {

    private int policy_number;
    private int client_id;
    private int age_since_built;
    private String type_of_dwelling;
    private String heating_type;


    public Home(int policy_number, int client_id, int age_since_built, String type_of_dwelling, String heating_type) {
        this.policy_number = policy_number;
        this.client_id = client_id;
        this.age_since_built = age_since_built;
        this.type_of_dwelling = type_of_dwelling;
        this.heating_type = heating_type;
    }

    public Home(){

    }

    public int getPolicy_number() {
        return policy_number;
    }

    public void setPolicy_number(int policy_number) {
        this.policy_number = policy_number;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
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

    @Override
    public String toString() {
        return "Home{" +
                "policy_number=" + policy_number +
                ", client_id=" + client_id +
                ", age_since_built=" + age_since_built +
                ", type_of_dwelling='" + type_of_dwelling + '\'' +
                ", heating_type='" + heating_type + '\'' +
                '}';
    }
}
