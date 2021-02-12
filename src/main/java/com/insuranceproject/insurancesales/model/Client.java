package com.insuranceproject.insurancesales.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Client {

    private UUID client_id;
    private String main_insured_name;
    private int home_policy_number;
    private int auto_policy_number;
    private String address;


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





    public UUID getClient_id() {
        return client_id;
    }

    public void setClient_id(UUID client_id) {
        this.client_id = client_id;
    }

    public Client(@JsonProperty("client_id") UUID client_id,@JsonProperty("main_insured_name") String main_insured_name) {
        this.client_id = client_id;
        this.main_insured_name = main_insured_name;
    }






    public String getMain_insured_name() {
        return this.main_insured_name;
    }

}
