package com.insuranceproject.insurancesales.model;

public class Home_Policy_Rate {

    private int home_policy_rate_id;
    private float base_premium_rate;
    private float tax_rate;
    private float home_age_25_or_over_rate;
    private float home_age_50_or_over_rate;
    private float oil_heat_rate;
    private float wood_heat_rate;
    private float other_heat_rate;


    public Home_Policy_Rate(int home_policy_rate_id, float base_premium_rate, float tax_rate, float home_age_25_or_over_rate, float home_age_50_or_over_rate, float oil_heat_rate, float wood_heat_rate, float other_heat_rate) {
        this.home_policy_rate_id = home_policy_rate_id;
        this.base_premium_rate = base_premium_rate;
        this.tax_rate = tax_rate;
        this.home_age_25_or_over_rate = home_age_25_or_over_rate;
        this.home_age_50_or_over_rate = home_age_50_or_over_rate;
        this.oil_heat_rate = oil_heat_rate;
        this.wood_heat_rate = wood_heat_rate;
        this.other_heat_rate = other_heat_rate;
    }

    public int getHome_policy_rate_id() {
        return home_policy_rate_id;
    }

    public void setHome_policy_rate_id(int home_policy_rate_id) {
        this.home_policy_rate_id = home_policy_rate_id;
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

    public float getOil_heat_rate() {
        return oil_heat_rate;
    }

    public void setOil_heat_rate(float oil_heat_rate) {
        this.oil_heat_rate = oil_heat_rate;
    }

    public float getWood_heat_rate() {
        return wood_heat_rate;
    }

    public void setWood_heat_rate(float wood_heat_rate) {
        this.wood_heat_rate = wood_heat_rate;
    }

    public float getOther_heat_rate() {
        return other_heat_rate;
    }

    public void setOther_heat_rate(float other_heat_rate) {
        this.other_heat_rate = other_heat_rate;
    }

    @Override
    public String toString() {
        return "Home_Policy_Rate{" +
                "home_policy_rate_id=" + home_policy_rate_id +
                ", base_premium_rate=" + base_premium_rate +
                ", tax_rate=" + tax_rate +
                ", home_age_25_or_over_rate=" + home_age_25_or_over_rate +
                ", home_age_50_or_over_rate=" + home_age_50_or_over_rate +
                ", oil_heat_rate=" + oil_heat_rate +
                ", wood_heat_rate=" + wood_heat_rate +
                ", other_heat_rate=" + other_heat_rate +
                '}';
    }
}
