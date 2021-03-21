package com.insuranceproject.insurancesales.model;


import java.sql.Date;

/**
 * A class that represents the client table.
 */

//TODO : Implement controller, DAO interface and data access service

public class Client {

    private int client_id;
    private String main_insured_first_name;
    private String main_insured_last_name;
    private int user_id;
    private int home_policy_number;
    private int auto_policy_number;
    private int address_id;
    private Date client_birthday;





    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }


    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getMain_insured_first_name() {
        return main_insured_first_name;
    }

    public void setMain_insured_first_name(String main_insured_first_name) {
        this.main_insured_first_name = main_insured_first_name;
    }

    public String getMain_insured_last_name() {
        return main_insured_last_name;
    }

    public void setMain_insured_last_name(String main_insured_last_name) {
        this.main_insured_last_name = main_insured_last_name;
    }

    public int getHome_policy_number() {
        return home_policy_number;
    }

    public void setHome_policy_number(int home_policy_number) {
        this.home_policy_number = home_policy_number;
    }

    public int getAuto_policy_number() {
        return auto_policy_number;
    }

    public void setAuto_policy_number(int auto_policy_number) {
        this.auto_policy_number = auto_policy_number;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public Date getClient_birthday() {
        return client_birthday;
    }

    public void setClient_birthday(Date client_birthday) {
        this.client_birthday = client_birthday;
    }
}
