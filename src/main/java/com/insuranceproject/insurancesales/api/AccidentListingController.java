package com.insuranceproject.insurancesales.api;


import com.insuranceproject.insurancesales.dao.AccidentListingJDBCDAO;
import com.insuranceproject.insurancesales.model.AccidentListing;
import com.insuranceproject.insurancesales.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * API access point for accident listings.
 */
@RequestMapping("api/accident_listing")
@RestController
public class AccidentListingController {

    @Autowired
    private AccidentListingJDBCDAO accidentListingDAO;

    @Autowired
    public AccidentListingController(ClientService clientService, AccidentListingJDBCDAO accidentListingDAO) {
        this.accidentListingDAO = accidentListingDAO;
    }

    @PostMapping
    public void addAccident(@RequestBody AccidentListing accidentListing){
        accidentListingDAO.create(accidentListing);
    }

    @GetMapping
    public List<AccidentListing> selectAllClients(){
        return accidentListingDAO.list();
    }
}
