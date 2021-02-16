package com.insuranceproject.insurancesales.model;

import java.sql.Date;

/**
 * A class that represents the home_policy table.
 */

//TODO : Implement controller, DAO interface and data access service

public class Home_Policy {

    private int policy_number;
    private int client_id;
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

    public int getClient_id() {
        return client_id;
    }

    public int getPolicy_number() {
        return policy_number;
    }

    public void setPolicy_number(int policy_number) {
        this.policy_number = policy_number;
    }


    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getMain_insured_name() {
        return main_insured_name;
    }

    public void setMain_insured_name(String main_insured_name) {
        this.main_insured_name = main_insured_name;
    }

    public String getOther_insured_names() {
        return other_insured_names;
    }

    public void setOther_insured_names(String other_insured_names) {
        this.other_insured_names = other_insured_names;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public float getBase_premium() {
        return base_premium;
    }

    public void setBase_premium(float base_premium) {
        this.base_premium = base_premium;
    }

    public float getTax() {
        return tax;
    }

    public void setTax(float tax) {
        this.tax = tax;
    }

    public float getTotal_premium() {
        return total_premium;
    }

    public void setTotal_premium(float total_premium) {
        this.total_premium = total_premium;
    }

    public float getReplacement_cost_value() {
        return replacement_cost_value;
    }

    public void setReplacement_cost_value(float replacement_cost_value) {
        this.replacement_cost_value = replacement_cost_value;
    }

    public float getInjury_liability_limit() {
        return injury_liability_limit;
    }

    public void setInjury_liability_limit(float injury_liability_limit) {
        this.injury_liability_limit = injury_liability_limit;
    }

    public float getInjury_deductible() {
        return injury_deductible;
    }

    public void setInjury_deductible(float injury_deductible) {
        this.injury_deductible = injury_deductible;
    }

    public float getContents_liability_limit() {
        return contents_liability_limit;
    }

    public void setContents_liability_limit(float contents_liability_limit) {
        this.contents_liability_limit = contents_liability_limit;
    }

    public float getContents_deductible() {
        return contents_deductible;
    }

    public void setContents_deductible(float contents_deductible) {
        this.contents_deductible = contents_deductible;
    }



    public Home_Policy(){

    }
    public Home_Policy(int client_id, String main_insured_name, String other_insured_names, Date start_date, Date end_date, float base_premium, float tax, float total_premium, float replacement_cost_value, float injury_liability_limit, float injury_deductible, float contents_liability_limit, float contents_deductible) {
        this.client_id = client_id;
        this.main_insured_name = main_insured_name;
        this.other_insured_names = other_insured_names;
        this.start_date = start_date;
        this.end_date = end_date;
        this.base_premium = base_premium;
        this.tax = tax;
        this.total_premium = total_premium;
        this.replacement_cost_value = replacement_cost_value;
        this.injury_liability_limit = injury_liability_limit;
        this.injury_deductible = injury_deductible;
        this.contents_liability_limit = contents_liability_limit;
        this.contents_deductible = contents_deductible;
    }


    @Override
    public String toString() {
        return "Home_Policy{" +
                "policy_number=" + policy_number +
                ", client_id=" + client_id +
                ", main_insured_name='" + main_insured_name + '\'' +
                ", other_insured_names='" + other_insured_names + '\'' +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", base_premium=" + base_premium +
                ", tax=" + tax +
                ", total_premium=" + total_premium +
                ", replacement_cost_value=" + replacement_cost_value +
                ", injury_liability_limit=" + injury_liability_limit +
                ", injury_deductible=" + injury_deductible +
                ", contents_liability_limit=" + contents_liability_limit +
                ", contents_deductible=" + contents_deductible +
                '}';
    }


}
