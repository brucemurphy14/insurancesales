package com.insuranceproject.insurancesales.api;

import com.insuranceproject.insurancesales.dao.AutoRatesJDBCDAO;
import com.insuranceproject.insurancesales.dao.DriverRiskFactorsJDBCDAO;
import com.insuranceproject.insurancesales.model.AutoRate;
import com.insuranceproject.insurancesales.model.Client;
import com.insuranceproject.insurancesales.model.DriverRiskFactors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/auto_risk")
@RestController
public class DriverRiskFactorsController {

    private DriverRiskFactorsJDBCDAO driverRiskDAO;

    public DriverRiskFactorsController(DriverRiskFactorsJDBCDAO driverRiskDAO) {
        this.driverRiskDAO = driverRiskDAO;
    }

    @GetMapping(path = "{id}")
    public DriverRiskFactors get(@PathVariable("id") int id){
        return driverRiskDAO.get(id)
                .orElse(null);
    }

    @GetMapping
    public List<DriverRiskFactors> list(){
        return driverRiskDAO.list();
    }

}
