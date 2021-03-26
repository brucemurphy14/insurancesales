package com.insuranceproject.insurancesales.model;

import java.sql.Date;

public class HomeRiskFactors {
    private int homeAge;
    private String dwellingType;
    private String heatingType;

    public HomeRiskFactors(){

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
