package com.insuranceproject.insurancesales.model;
import java.util.UUID;

/**
 * A class that represents the Car table.
 */

//TODO : Implement controller, DAO interface and data access service
public class Car {

    private int vin_number;
    private int policy_number;
    private String vehicle_make;
    private String vehicle_model;
    private int vehicle_year;

    public int getVin_number() {
        return vin_number;
    }

    public void setVin_number(int vin_number) {
        this.vin_number = vin_number;
    }

    public int getPolicy_number() {
        return policy_number;
    }

    public void setPolicy_number(int policy_number) {
        this.policy_number = policy_number;
    }



    public String getVehicle_make() {
        return vehicle_make;
    }

    public void setVehicle_make(String vehicle_make) {
        this.vehicle_make = vehicle_make;
    }

    public String getVehicle_model() {
        return vehicle_model;
    }

    public void setVehicle_model(String vehicle_model) {
        this.vehicle_model = vehicle_model;
    }

    public int getVehicle_year() {
        return vehicle_year;
    }

    public void setVehicle_year(int vehicle_year) {
        this.vehicle_year = vehicle_year;
    }
}
