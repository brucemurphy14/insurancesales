package com.insuranceproject.insurancesales.api;

import com.insuranceproject.insurancesales.dao.AutoRatesJDBCDAO;
import com.insuranceproject.insurancesales.dao.HomeRatesJDBCDAO;
import com.insuranceproject.insurancesales.model.AutoRate;
import com.insuranceproject.insurancesales.model.HomeRate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/home_rates")
@RestController
public class HomeRateController {

    private HomeRatesJDBCDAO homeRate;
    public HomeRateController(HomeRatesJDBCDAO homeRate) {
        this.homeRate = homeRate;
    }

    @GetMapping
    public List<HomeRate> selectAllClients(){
        return homeRate.list();
    }


}
