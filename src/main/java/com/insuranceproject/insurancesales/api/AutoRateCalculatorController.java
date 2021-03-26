package com.insuranceproject.insurancesales.api;

import com.insuranceproject.insurancesales.dao.DriverRiskFactorsJDBCDAO;
import com.insuranceproject.insurancesales.model.DriverRiskFactors;
import com.insuranceproject.insurancesales.model.Policy_Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RequestMapping("api/auto_premium_rating")
@RestController
public class AutoRateCalculatorController {
    @Autowired
    Policy_Factory policy_factory;
    @Autowired
    DriverRiskFactorsJDBCDAO driverRiskFactors;

    public AutoRateCalculatorController(Policy_Factory policy_factory) {
        this.policy_factory = policy_factory;

    }


    @GetMapping(path = "{id}")
    public float getDriversAutoPremium(@PathVariable("id") int id){
         return policy_factory.generateAutoRate(driverRiskFactors.get(id).orElse(null));
    }

}
