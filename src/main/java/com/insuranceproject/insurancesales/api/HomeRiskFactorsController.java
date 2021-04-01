package com.insuranceproject.insurancesales.api;

import com.insuranceproject.insurancesales.dao.HomeRatesJDBCDAO;
import com.insuranceproject.insurancesales.dao.HomeRiskFactorsJDBCDAO;
import com.insuranceproject.insurancesales.model.HomeRiskFactors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/home_risk")
@RestController
public class HomeRiskFactorsController {
    @Autowired
    HomeRiskFactorsJDBCDAO homeRiskDAO;

    @Autowired
    HomeRatesJDBCDAO homeRatesDAO;

    public HomeRiskFactorsController(HomeRiskFactorsJDBCDAO homeRiskDAO, HomeRatesJDBCDAO homeRatesDAO) {
        this.homeRiskDAO = homeRiskDAO;
        this.homeRatesDAO = homeRatesDAO;
    }


    @GetMapping(path = "{id}")
    public HomeRiskFactors getDriversRiskFactor(@PathVariable("id") int id){
        return homeRiskDAO.get(id)
                .orElse(null);
    }

    @GetMapping
    public List<HomeRiskFactors> list(){

        return homeRiskDAO.list();
    }
}
