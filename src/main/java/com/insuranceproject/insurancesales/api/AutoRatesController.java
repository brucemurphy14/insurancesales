package com.insuranceproject.insurancesales.api;


import com.insuranceproject.insurancesales.dao.AutoRatesJDBCDAO;
import com.insuranceproject.insurancesales.model.AutoRate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/auto_rates")
@RestController
public class AutoRatesController {

 private AutoRatesJDBCDAO autoRate;

    public AutoRatesController(AutoRatesJDBCDAO autoRate) {
        this.autoRate = autoRate;
    }

    @GetMapping
    public List<AutoRate> selectAllClients(){
        return autoRate.list();
    }
}
