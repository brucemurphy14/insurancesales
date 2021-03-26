package com.insuranceproject.insurancesales.model;


import com.insuranceproject.insurancesales.dao.AutoRatesJDBCDAO;
import com.insuranceproject.insurancesales.dao.HomeRatesJDBCDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public class Policy_Factory{
    @Autowired
    private  AutoRatesJDBCDAO autoRatesTable;

    public  float generateAutoRate(DriverRiskFactors driverRiskFactors){
        float totalPolicyCost;
        float basePremiumRate ;
        int driverAge = driverRiskFactors.getDriverAge();
        float driverAgeRate = 0;
        int vehicleAge = driverRiskFactors.getVehicleAge();
        float vehicleAgeRate = 0;
        float vehicleWorth = driverRiskFactors.getVehicleWorth();
        int accidents_last_5_years = driverRiskFactors.getAccidentCount();
        float accidentRatingLast5Years = 0;
        basePremiumRate = autoRatesTable.list().get(0).getBase_premium_rate();
        if (driverAge < 25){
            driverAgeRate = autoRatesTable.list().get(0).getDriver_age_25_or_under_rate();
        }
        else {
            driverAgeRate = autoRatesTable.list().get(0).getDriver_age_other_rate();
        }



        if (vehicleAge > 200){
            vehicleAgeRate = autoRatesTable.list().get(0).getCar_11_years_or_older_rate();
        }



        if (accidents_last_5_years == 0){
            accidentRatingLast5Years = 1.00f;
        }
        else if (accidents_last_5_years == 1){
            accidentRatingLast5Years = 1.25f;
        }
        else if (accidents_last_5_years == 2){
            accidentRatingLast5Years = 2.5f;
        }


        System.out.println(basePremiumRate);
        System.out.println(driverAgeRate);
        System.out.println(accidentRatingLast5Years);
        System.out.println(vehicleAgeRate);

        totalPolicyCost = basePremiumRate * driverAgeRate * accidentRatingLast5Years * vehicleAgeRate;
        System.out.println(totalPolicyCost);
        return totalPolicyCost;


    }

    public void makePolicy(){
    }

    private float homePremiumCalculator(){
        return 1.0f;
    }

}
