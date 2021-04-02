package com.insuranceproject.insurancesales.model;

public class DriverRiskFactors {

    /**
     * A pojo that represents the factors that a given client has for auto policy cost calculations.
     */
    private float calculatedPremium;
    int driverAge;
    int vehicleAge;
    int accidentCount;
    float vehicleWorth;
    String location_type;

    public DriverRiskFactors(){

    }

    public float getCalculatedPremium() {
        return calculatedPremium;
    }

    public void setCalculatedPremium(float calculatedPremium) {
        this.calculatedPremium = calculatedPremium;
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
