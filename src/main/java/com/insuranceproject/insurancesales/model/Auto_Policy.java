package com.insuranceproject.insurancesales.model;

/**
 * A class that represents the auto_policy table.
 */

import java.sql.Date;

//TODO : Implement controller, DAO interface and data access service
public class Auto_Policy {

    private int policy_number;
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


    public Auto_Policy() {
    }

    public Auto_Policy( String main_insured_name, Date start_date, Date end_date, float base_premium, float tax, float total_premium, float driver_age, int number_of_accidents_last_5_years, String address) {
        this.main_insured_name = main_insured_name;
        this.start_date = start_date;
        this.end_date = end_date;
        this.base_premium = base_premium;
        this.tax = tax;
        this.total_premium = total_premium;
        this.driver_age = driver_age;
        this.number_of_accidents_last_5_years = number_of_accidents_last_5_years;
        this.address = address;
    }
}
