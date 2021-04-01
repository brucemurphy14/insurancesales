package com.insuranceproject.insurancesales.api;

import com.insuranceproject.insurancesales.dao.HomeRiskFactorsJDBCDAO;
import com.insuranceproject.insurancesales.model.HomeRiskFactors;
import com.insuranceproject.insurancesales.model.Policy_Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/home_premium_rating")
@RestController
public class HomeRateCalculatorController {
    @Autowired
    Policy_Factory policy_factory;
    @Autowired
    HomeRiskFactorsJDBCDAO homeRiskFactors;

    public HomeRateCalculatorController(Policy_Factory policy_factory) {
        this.policy_factory = policy_factory;
    }

    @GetMapping(path = "{id}")
    public HomeRiskFactors getHomePremium(@PathVariable("id") int id){
        return policy_factory.generateHomeRate(homeRiskFactors.get(id).orElse(null));
    }

    @PostMapping()
    public HomeRiskFactors getHomeQuotePremium(@RequestBody HomeRiskFactors homeRiskFactors) {
        return policy_factory.generateHomeRate(homeRiskFactors);
    }
}
