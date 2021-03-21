package com.insuranceproject.insurancesales.model;

import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Date;

public class DriverRiskFactors {
    Date driverAge;
    int vehicleAge;
    int accidentCount;

    public DriverRiskFactors(){

    }

    public Date getDriverAge() {
        return driverAge;
    }

    public void setDriverAge(Date driverAge) {
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
