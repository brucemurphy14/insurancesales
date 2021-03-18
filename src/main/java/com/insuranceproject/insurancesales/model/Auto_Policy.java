package com.insuranceproject.insurancesales.model;

/**
 * A class that represents the auto_policy table.
 */

import java.sql.Date;

//TODO : Implement controller, DAO interface and data access service
public class Auto_Policy {

    private int policy_number;
    private int client_id;
    private int VIN_number;

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

    public int getVIN_number() {
        return VIN_number;
    }

    public void setVIN_number(int VIN_number) {
        this.VIN_number = VIN_number;
    }
}
