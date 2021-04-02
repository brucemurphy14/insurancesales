package com.insuranceproject.insurancesales.model;

import java.sql.Date;

/**
 * A POJO that represents the home_policy table.
 */

//TODO : Implement controller, DAO interface and data access service

public class Home_Policy {

    private int policy_number;
    private int client_id;
    private int home_id;

    public Home_Policy(int policy_number, int client_id, int home_id) {
        this.policy_number = policy_number;
        this.client_id = client_id;
        this.home_id = home_id;
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

    public int getHome_id() {
        return home_id;
    }

    public void setHome_id(int home_id) {
        this.home_id = home_id;
    }

    public Home_Policy(){

    }





}
