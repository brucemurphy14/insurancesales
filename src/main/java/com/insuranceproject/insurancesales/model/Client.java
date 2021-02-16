package com.insuranceproject.insurancesales.model;


/**
 * A class that represents the client table.
 */

//TODO : Implement controller, DAO interface and data access service

public class Client {

    private int client_id;
    private String main_insured_name;
    private int home_policy_number;
    private int auto_policy_number;
    private String address;

    public Client() {
    }

    public Client(String main_insured_name, int home_policy_number, int auto_policy_number, String address) {
        this.main_insured_name = main_insured_name;
        this.home_policy_number = home_policy_number;
        this.auto_policy_number = auto_policy_number;
        this.address = address;
    }
    public void setMain_insured_name(String main_insured_name) {
        this.main_insured_name = main_insured_name;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getClient_id() {
        return this.client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getMain_insured_name() {
        return this.main_insured_name;
    }


    @Override
    public String toString() {
        return "Client{" +
                "client_id=" + client_id +
                ", main_insured_name='" + main_insured_name + '\'' +
                ", home_policy_number=" + home_policy_number +
                ", auto_policy_number=" + auto_policy_number +
                ", address='" + address + '\'' +
                '}';
    }
}
