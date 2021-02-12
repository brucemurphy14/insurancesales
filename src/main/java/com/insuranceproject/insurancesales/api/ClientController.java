package com.insuranceproject.insurancesales.api;

import com.insuranceproject.insurancesales.model.Client;
import com.insuranceproject.insurancesales.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/client")
@RestController
public class ClientController {

    private  final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public void addClient(@RequestBody Client client){
        clientService.addClient(client);
    }

    @GetMapping
    public List<Client> selectAllClients(){

        return clientService.getAllClients();
    }
}
