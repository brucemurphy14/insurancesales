package com.insuranceproject.insurancesales.model;

public class Policy_Holder {
    private int policy_holder_id;
    private int policy_number;
    private int client_id;


    public Policy_Holder() {

    }

    public int getPolicy_holder_id() {
        return policy_holder_id;
    }

    public void setPolicy_holder_id(int policy_holder_id) {
        this.policy_holder_id = policy_holder_id;
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
}
