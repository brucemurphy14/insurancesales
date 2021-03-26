package com.insuranceproject.insurancesales.model;

import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Date;

public class DriverRiskFactors {
    int driverAge;
    int vehicleAge;
    int accidentCount;
    float vehicleWorth;
    String location_type;

    public DriverRiskFactors(){

    }


    public String getLocation_type() {
        return location_type;
    }

    public void setLocation_type(String location_type) {
        this.location_type = location_type;
    }

    public float getVehicleWorth() {
        return vehicleWorth;
    }

    public void setVehicleWorth(float vehicleWorth) {
        this.vehicleWorth = vehicleWorth;
    }

    public int getDriverAge() {
        return driverAge;
    }

    public void setDriverAge(int driverAge) {
        this.driverAge = driverAge;
    }

    public int getVehicleAge() {
        return vehicleAge;
    }

    public void setVehicleAge(int vehicleAge) {
        this.vehicleAge = vehicleAge;
    }

    public int getAccidentCount() {
        return accidentCount;
    }

    public void setAccidentCount(int accidentCount) {
        this.accidentCount = accidentCount;
    }


}
