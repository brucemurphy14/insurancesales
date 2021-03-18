package com.insuranceproject.insurancesales.model;

import java.sql.Date;

public class Policy_Factory {

    private int policy_factory_id;
    private int client_id;
    private String main_insured_name;
    private Date start_date;
    private Date end_date;
    private float base_premium;
    private float tax;
    private float total_premium;
    private float driver_age;
    private int number_of_accidents_last_5_years;
    private String address;
    private float replacement_cost_value;
    private float injury_liability_limit;
    private float injury_deductible;
    private float contents_liability_limit;
    private float contents_deductible;
    private int rating_details_auto;
    private int rating_details_home;

    public Policy_Factory(int policy_factory_id, int client_id, String main_insured_name, Date start_date, Date end_date, float base_premium, float tax, float total_premium, float driver_age, int number_of_accidents_last_5_years, String address, float replacement_cost_value, float injury_liability_limit, float injury_deductible, float contents_liability_limit, float contents_deductible, int rating_details_auto, int rating_details_home) {
        this.policy_factory_id = policy_factory_id;
        this.client_id = client_id;
        this.main_insured_name = main_insured_name;
        this.start_date = start_date;
        this.end_date = end_date;
        this.base_premium = base_premium;
        this.tax = tax;
        this.total_premium = total_premium;
        this.driver_age = driver_age;
        this.number_of_accidents_last_5_years = number_of_accidents_last_5_years;
        this.address = address;
        this.replacement_cost_value = replacement_cost_value;
        this.injury_liability_limit = injury_liability_limit;
        this.injury_deductible = injury_deductible;
        this.contents_liability_limit = contents_liability_limit;
        this.contents_deductible = contents_deductible;
        this.rating_details_auto = rating_details_auto;
        this.rating_details_home = rating_details_home;
    }

    public int getPolicy_factory_id() {
        return policy_factory_id;
    }

    public void setPolicy_factory_id(int policy_factory_id) {
        this.policy_factory_id = policy_factory_id;
    }

    public int getClient_id() {
        return client_id;
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

    public float getDriver_age() {
        return driver_age;
    }

    public void setDriver_age(float driver_age) {
        this.driver_age = driver_age;
    }

    public int getNumber_of_accidents_last_5_years() {
        return number_of_accidents_last_5_years;
    }

    public void setNumber_of_accidents_last_5_years(int number_of_accidents_last_5_years) {
        this.number_of_accidents_last_5_years = number_of_accidents_last_5_years;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public int getRating_details_auto() {
        return rating_details_auto;
    }

    public void setRating_details_auto(int rating_details_auto) {
        this.rating_details_auto = rating_details_auto;
    }

    public int getRating_details_home() {
        return rating_details_home;
    }

    public void setRating_details_home(int rating_details_home) {
        this.rating_details_home = rating_details_home;
    }

    @Override
    public String toString() {
        return "Policy_Factory{" +
                "policy_factory_id=" + policy_factory_id +
                ", client_id=" + client_id +
                ", main_insured_name='" + main_insured_name + '\'' +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", base_premium=" + base_premium +
                ", tax=" + tax +
                ", total_premium=" + total_premium +
                ", driver_age=" + driver_age +
                ", number_of_accidents_last_5_years=" + number_of_accidents_last_5_years +
                ", address='" + address + '\'' +
                ", replacement_cost_value=" + replacement_cost_value +
                ", injury_liability_limit=" + injury_liability_limit +
                ", injury_deductible=" + injury_deductible +
                ", contents_liability_limit=" + contents_liability_limit +
                ", contents_deductible=" + contents_deductible +
                ", rating_details_auto=" + rating_details_auto +
                ", rating_details_home=" + rating_details_home +
                '}';
    }
}
