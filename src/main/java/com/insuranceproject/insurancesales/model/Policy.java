package com.insuranceproject.insurancesales.model;

import java.sql.Date;

/**
 * A POJO that represents the policy table.
 */
public class Policy {
    private int policy_number;
    private int client_id;
    private String policy_type;
    private Float term_price;
    private Date start_date;




    public Policy(){

    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public String getPolicy_type() {
        return policy_type;
    }

    public void setPolicy_type(String policy_type) {
        this.policy_type = policy_type;
    }

    public Float getTerm_price() {
        return term_price;
    }

    public void setTerm_price(Float term_price) {
        this.term_price = term_price;
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
