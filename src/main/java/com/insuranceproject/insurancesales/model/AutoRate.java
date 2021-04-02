package com.insuranceproject.insurancesales.model;

/**
 * A pojo that represents the auto_rate table. Contains the rating factors for policy cost calculation.
 */
public class AutoRate {
    private int auto_policy_rate_id;
    private float base_premium_rate;
    private float driver_age_25_or_under_rate;
    private float driver_age_other_rate;

    private float location_rate_dense_urban;
    private float location_rate_urban;
    private float location_rate_rural;

    private float no_accidents_last_5_years_rate;
    private float one_accident_last_5_years_rate;
    private float two_or_more_accidents_last_5_years_rate;


    private float car_11_years_or_older_rate;
    private float car_older_than_5_years_rate;
    private float car_age_other_rate;


    public AutoRate(int auto_policy_rate_id, float base_premium_rate, float driver_age_25_or_under_rate, float driver_age_other_rate, float location_rate_dense_urban, float location_rate_urban, float location_rate_rural, float no_accidents_last_5_years_rate, float one_accident_last_5_years_rate, float two_or_more_accidents_last_5_years_rate, float car_11_years_or_older_rate, float car_older_than_5_years_rate, float car_age_other_rate, float base_premium) {
        this.auto_policy_rate_id = auto_policy_rate_id;
        this.base_premium_rate = base_premium_rate;
        this.driver_age_25_or_under_rate = driver_age_25_or_under_rate;
        this.driver_age_other_rate = driver_age_other_rate;
        this.location_rate_dense_urban = location_rate_dense_urban;
        this.location_rate_urban = location_rate_urban;
        this.location_rate_rural = location_rate_rural;
        this.no_accidents_last_5_years_rate = no_accidents_last_5_years_rate;
        this.one_accident_last_5_years_rate = one_accident_last_5_years_rate;
        this.two_or_more_accidents_last_5_years_rate = two_or_more_accidents_last_5_years_rate;
        this.car_11_years_or_older_rate = car_11_years_or_older_rate;
        this.car_older_than_5_years_rate = car_older_than_5_years_rate;
        this.car_age_other_rate = car_age_other_rate;

    }

    public AutoRate(){

    }

    public int getAuto_policy_rate_id() {
        return auto_policy_rate_id;
    }

    public void setAuto_policy_rate_id(int auto_policy_rate_id) {
        this.auto_policy_rate_id = auto_policy_rate_id;
    }

    public float getBase_premium_rate() {
        return base_premium_rate;
    }

    public void setBase_premium_rate(float base_premium_rate) {
        this.base_premium_rate = base_premium_rate;
    }

    public float getDriver_age_25_or_under_rate() {
        return driver_age_25_or_under_rate;
    }

    public void setDriver_age_25_or_under_rate(float driver_age_25_or_under_rate) {
        this.driver_age_25_or_under_rate = driver_age_25_or_under_rate;
    }

    public float getDriver_age_other_rate() {
        return driver_age_other_rate;
    }

    public void setDriver_age_other_rate(float driver_age_other_rate) {
        this.driver_age_other_rate = driver_age_other_rate;
    }

    public float getLocation_rate_dense_urban() {
        return location_rate_dense_urban;
    }

    public void setLocation_rate_dense_urban(float location_rate_dense_urban) {
        this.location_rate_dense_urban = location_rate_dense_urban;
    }

    public float getLocation_rate_urban() {
        return location_rate_urban;
    }

    public void setLocation_rate_urban(float location_rate_urban) {
        this.location_rate_urban = location_rate_urban;
    }

    public float getLocation_rate_rural() {
        return location_rate_rural;
    }

    public void setLocation_rate_rural(float location_rate_rural) {
        this.location_rate_rural = location_rate_rural;
    }

    public float getNo_accidents_last_5_years_rate() {
        return no_accidents_last_5_years_rate;
    }

    public void setNo_accidents_last_5_years_rate(float no_accidents_last_5_years_rate) {
        this.no_accidents_last_5_years_rate = no_accidents_last_5_years_rate;
    }

    public float getOne_accident_last_5_years_rate() {
        return one_accident_last_5_years_rate;
    }

    public void setOne_accident_last_5_years_rate(float one_accident_last_5_years_rate) {
        this.one_accident_last_5_years_rate = one_accident_last_5_years_rate;
    }

    public float getTwo_or_more_accidents_last_5_years_rate() {
        return two_or_more_accidents_last_5_years_rate;
    }

    public void setTwo_or_more_accidents_last_5_years_rate(float two_or_more_accidents_last_5_years_rate) {
        this.two_or_more_accidents_last_5_years_rate = two_or_more_accidents_last_5_years_rate;
    }

    public float getCar_11_years_or_older_rate() {
        return car_11_years_or_older_rate;
    }

    public void setCar_11_years_or_older_rate(float car_11_years_or_older_rate) {
        this.car_11_years_or_older_rate = car_11_years_or_older_rate;
    }

    public float getCar_older_than_5_years_rate() {
        return car_older_than_5_years_rate;
    }

    public void setCar_older_than_5_years_rate(float car_older_than_5_years_rate) {
        this.car_older_than_5_years_rate = car_older_than_5_years_rate;
    }

    public float getCar_age_other_rate() {
        return car_age_other_rate;
    }

    public void setCar_age_other_rate(float car_age_other_rate) {
        this.car_age_other_rate = car_age_other_rate;
    }

}
