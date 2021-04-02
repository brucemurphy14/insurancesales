package com.insuranceproject.insurancesales.model;

/**
 * A POJO that contains a clients individual risk rating for a home policy.
 */
public class HomeRiskFactors {
    private float calculatedPremium;
    private int homeAge;
    private String dwellingType;
    private String heatingType;

    public HomeRiskFactors(){

    }

    public float getCalculatedPremium() {
        return calculatedPremium;
    }

    public void setCalculatedPremium(float calculatedPremium) {
        this.calculatedPremium = calculatedPremium;
    }

    public int getHomeAge() {
        return homeAge;
    }

    public void setHomeAge(int homeAge) {
        this.homeAge = homeAge;
    }

    public String getDwellingType() {
        return dwellingType;
    }

    public void setDwellingType(String dwellingType) {
        this.dwellingType = dwellingType;
    }

    public String getHeatingType() {
        return heatingType;
    }

    public void setHeatingType(String heatingType) {
        this.heatingType = heatingType;
    }
}
