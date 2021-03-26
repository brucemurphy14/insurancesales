package com.insuranceproject.insurancesales.model;

public class HomeRate {
    private int home_policy_rate_id;
    private float dwelling_type_single_dwelling_rate;
    private float dwelling_type_apartment_rate;
    private float dwelling_type_bungalow_rate;
    private float dwelling_type_single_attached_rate;
    private float base_premium_rate;
    private float tax_rate;
    private float home_age_under_25_rate;
    private float home_age_25_or_over_rate;
    private float home_age_50_or_over_rate;
    private float heating_type_electric_rate;
    private float heating_type_oil_rate;
    private float heating_type_gas_rate;
    private float heating_type_wood_rate;
    private float heating_type_other_rate;

    public HomeRate(int home_policy_rate_id, float dwelling_type_single_dwelling_rate, float dwelling_type_apartment_rate, float dwelling_type_bungalow_rate, float dwelling_type_single_attached_rate, float base_premium_rate, float tax_rate, float home_age_under_25_rate, float home_age_25_or_over_rate, float home_age_50_or_over_rate, float heating_type_electric_rate, float heating_type_oil_rate, float heating_type_gas_rate, float heating_type_wood_rate, float heating_type_other_rate, float other_heat_rate) {
        this.home_policy_rate_id = home_policy_rate_id;
        this.dwelling_type_single_dwelling_rate = dwelling_type_single_dwelling_rate;
        this.dwelling_type_apartment_rate = dwelling_type_apartment_rate;
        this.dwelling_type_bungalow_rate = dwelling_type_bungalow_rate;
        this.dwelling_type_single_attached_rate = dwelling_type_single_attached_rate;
        this.base_premium_rate = base_premium_rate;
        this.tax_rate = tax_rate;
        this.home_age_under_25_rate = home_age_under_25_rate;
        this.home_age_25_or_over_rate = home_age_25_or_over_rate;
        this.home_age_50_or_over_rate = home_age_50_or_over_rate;
        this.heating_type_electric_rate = heating_type_electric_rate;
        this.heating_type_oil_rate = heating_type_oil_rate;
        this.heating_type_gas_rate = heating_type_gas_rate;
        this.heating_type_wood_rate = heating_type_wood_rate;
        this.heating_type_other_rate = heating_type_other_rate;
    }

    public HomeRate(){

    }

    public int getHome_policy_rate_id() {
        return home_policy_rate_id;
    }

    public void setHome_policy_rate_id(int home_policy_rate_id) {
        this.home_policy_rate_id = home_policy_rate_id;
    }

    public float getDwelling_type_single_dwelling_rate() {
        return dwelling_type_single_dwelling_rate;
    }

    public void setDwelling_type_single_dwelling_rate(float dwelling_type_single_dwelling_rate) {
        this.dwelling_type_single_dwelling_rate = dwelling_type_single_dwelling_rate;
    }

    public float getDwelling_type_apartment_rate() {
        return dwelling_type_apartment_rate;
    }

    public void setDwelling_type_apartment_rate(float dwelling_type_apartment_rate) {
        this.dwelling_type_apartment_rate = dwelling_type_apartment_rate;
    }

    public float getDwelling_type_bungalow_rate() {
        return dwelling_type_bungalow_rate;
    }

    public void setDwelling_type_bungalow_rate(float dwelling_type_bungalow_rate) {
        this.dwelling_type_bungalow_rate = dwelling_type_bungalow_rate;
    }

    public float getDwelling_type_single_attached_rate() {
        return dwelling_type_single_attached_rate;
    }

    public void setDwelling_type_single_attached_rate(float dwelling_type_single_attached_rate) {
        this.dwelling_type_single_attached_rate = dwelling_type_single_attached_rate;
    }

    public float getBase_premium_rate() {
        return base_premium_rate;
    }

    public void setBase_premium_rate(float base_premium_rate) {
        this.base_premium_rate = base_premium_rate;
    }

    public float getTax_rate() {
        return tax_rate;
    }

    public void setTax_rate(float tax_rate) {
        this.tax_rate = tax_rate;
    }

    public float getHome_age_under_25_rate() {
        return home_age_under_25_rate;
    }

    public void setHome_age_under_25_rate(float home_age_under_25_rate) {
        this.home_age_under_25_rate = home_age_under_25_rate;
    }

    public float getHome_age_25_or_over_rate() {
        return home_age_25_or_over_rate;
    }

    public void setHome_age_25_or_over_rate(float home_age_25_or_over_rate) {
        this.home_age_25_or_over_rate = home_age_25_or_over_rate;
    }

    public float getHome_age_50_or_over_rate() {
        return home_age_50_or_over_rate;
    }

    public void setHome_age_50_or_over_rate(float home_age_50_or_over_rate) {
        this.home_age_50_or_over_rate = home_age_50_or_over_rate;
    }

    public float getHeating_type_electric_rate() {
        return heating_type_electric_rate;
    }

    public void setHeating_type_electric_rate(float heating_type_electric_rate) {
        this.heating_type_electric_rate = heating_type_electric_rate;
    }

    public float getHeating_type_oil_rate() {
        return heating_type_oil_rate;
    }

    public void setHeating_type_oil_rate(float heating_type_oil_rate) {
        this.heating_type_oil_rate = heating_type_oil_rate;
    }

    public float getHeating_type_gas_rate() {
        return heating_type_gas_rate;
    }

    public void setHeating_type_gas_rate(float heating_type_gas_rate) {
        this.heating_type_gas_rate = heating_type_gas_rate;
    }

    public float getHeating_type_wood_rate() {
        return heating_type_wood_rate;
    }

    public void setHeating_type_wood_rate(float heating_type_wood_rate) {
        this.heating_type_wood_rate = heating_type_wood_rate;
    }

    public float getHeating_type_other_rate() {
        return heating_type_other_rate;
    }

    public void setHeating_type_other_rate(float heating_type_other_rate) {
        this.heating_type_other_rate = heating_type_other_rate;
    }


}

