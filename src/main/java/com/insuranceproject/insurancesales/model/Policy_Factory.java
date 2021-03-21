package com.insuranceproject.insurancesales.model;


import com.insuranceproject.insurancesales.dao.AutoRatesJDBCDAO;
import com.insuranceproject.insurancesales.dao.HomeRatesJDBCDAO;
import org.springframework.stereotype.Component;

@Component
public class Policy_Factory{


    AutoRatesJDBCDAO autoRatesTable;
    HomeRatesJDBCDAO homeRatesTable;

    public Policy_Factory(AutoRatesJDBCDAO autoRatesTable, HomeRatesJDBCDAO homeRatesTable) {
        this.autoRatesTable = autoRatesTable;
        this.homeRatesTable = homeRatesTable;
    }

    private float homePremiumCalculator(){
        return 1.0f;
    }




}
