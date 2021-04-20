package com.insuranceproject.insurancesales.model;


import com.insuranceproject.insurancesales.dao.AutoRatesJDBCDAO;
import com.insuranceproject.insurancesales.dao.HomeRatesJDBCDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * This class calculates the premium cost of Auto/Home insurance rates.
 * Uses the DAO for both rates tables to compare to inputted values.
 * Both methods use the class for individual risk rates from home/auto as inputs and outputs the premium for a policy.
 */
@Component
public class Policy_Factory{
    @Autowired
    private  AutoRatesJDBCDAO autoRatesTable;
    @Autowired
    private HomeRatesJDBCDAO homeRatesTable;

    public DriverRiskFactors generateAutoRate(DriverRiskFactors driverRiskFactors){
        float totalPolicyCost = 0;
        float basePremiumRate = 0;
        float locationRate = 0;

        int driverAge = 0;
        driverAge = driverRiskFactors.getDriverAge();
        float driverAgeRate = 0;
        int vehicleAge = driverRiskFactors.getVehicleAge();
        float vehicleAgeRate = 0;
        float vehicleWorth = driverRiskFactors.getVehicleWorth();
        int accidents_last_5_years = driverRiskFactors.getAccidentCount();
        float accidentRatingLast5Years = 0;
        basePremiumRate = autoRatesTable.list().get(0).getBase_premium_rate();

        String locationType = driverRiskFactors.getLocation_type();


        if (driverAge <= 25){
            driverAgeRate = autoRatesTable.list().get(0).getDriver_age_25_or_under_rate();
        }
        else {
            driverAgeRate = autoRatesTable.list().get(0).getDriver_age_other_rate();
        }

        switch (locationType) {
            case "Dense Urban" -> locationRate = autoRatesTable.list().get(0).getLocation_rate_dense_urban();
            case "Urban" -> locationRate = autoRatesTable.list().get(0).getLocation_rate_urban();
            case "Rural" -> locationRate = autoRatesTable.list().get(0).getLocation_rate_rural();
        }


        if (vehicleAge > 10){
            vehicleAgeRate = autoRatesTable.list().get(0).getCar_11_years_or_older_rate();
        }

        else{
            vehicleAgeRate = 0.25f;
        }



        if (accidents_last_5_years == 0){
            accidentRatingLast5Years = 1.00f;
        }
        else if (accidents_last_5_years == 1){
            accidentRatingLast5Years = 1.25f;
        }
        else if (accidents_last_5_years >= 2){
            accidentRatingLast5Years = 2.5f;
        }


        System.out.println("base premium rate:" + basePremiumRate);
        System.out.println("driver aGE RATE:" + driverAgeRate);
        System.out.println("accidentrating last 5 years rate:" + accidentRatingLast5Years);
        System.out.println("vehicleagerate" + vehicleAgeRate);

        totalPolicyCost = basePremiumRate * driverAgeRate * accidentRatingLast5Years *locationRate/* vehicleAgeRate*/;
       // System.out.println(totalPolicyCost);
        driverRiskFactors.setCalculatedPremium(totalPolicyCost);

        return  driverRiskFactors;
    }


    public HomeRiskFactors generateHomeRate(HomeRiskFactors homeRiskFactors){
        float totalPremiumCost = 0;
        float basePremiumRate = 0;

        int homeAge = 0;
        float homeAgeRate = 0;

        String heatingType;
        float heatingtypeRate = 0;

        String dwellingType;
        float dwellingTypeRate = 0;


        basePremiumRate = homeRatesTable.list().get(0).getBase_premium_rate();
        homeAge = homeRiskFactors.getHomeAge();
        heatingType = homeRiskFactors.getHeatingType();
        dwellingType = homeRiskFactors.getDwellingType();

        if (homeAge < 25){
            homeAgeRate = homeRatesTable.list().get(0).getHome_age_under_25_rate();
        }

        else if (homeAge < 50 ){
            homeAgeRate = homeRatesTable.list().get(0).getHome_age_25_or_over_rate();
        }
        else if (homeAge >= 50){
            homeAgeRate = homeRatesTable.list().get(0).getHome_age_50_or_over_rate();
        }


        if (heatingType.equals("Electric")){
            heatingtypeRate = homeRatesTable.list().get(0).getHeating_type_electric_rate();
        }

        else if (heatingType.equals("Oil")){
            heatingtypeRate = homeRatesTable.list().get(0).getHeating_type_oil_rate();
        }

        else if (heatingType.equals("Wood")){
            heatingtypeRate = homeRatesTable.list().get(0).getHeating_type_wood_rate();
        }

        else if (heatingType.equals("Gas")){
            heatingtypeRate = homeRatesTable.list().get(0).getHeating_type_gas_rate();
        }

        else if (heatingType.equals("Other")){
            heatingtypeRate = homeRatesTable.list().get(0).getHeating_type_other_rate();
        }

        if (dwellingType.equals("Single Dwelling")){
            dwellingTypeRate = homeRatesTable.list().get(0).getDwelling_type_single_dwelling_rate();
        }

        else if (dwellingType.equals("Apartment")){
            dwellingTypeRate = homeRatesTable.list().get(0).getDwelling_type_apartment_rate();
        }

        else if (dwellingType.equals("Bungalow")){
            dwellingTypeRate = homeRatesTable.list().get(0).getDwelling_type_bungalow_rate();
        }

        else if (dwellingType.equals("Semi-Attached")){
            dwellingTypeRate = homeRatesTable.list().get(0).getDwelling_type_single_attached_rate();
        }


         System.out.println(dwellingTypeRate);
         System.out.println(dwellingType);
         System.out.println(basePremiumRate);
         System.out.println(heatingtypeRate);

        totalPremiumCost =  basePremiumRate *  homeAgeRate * heatingtypeRate * dwellingTypeRate;
        homeRiskFactors.setCalculatedPremium(totalPremiumCost);

        return homeRiskFactors;


    }

    public void makePolicy(){


    }

}
