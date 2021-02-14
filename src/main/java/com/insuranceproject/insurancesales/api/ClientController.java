package com.insuranceproject.insurancesales.api;

import com.insuranceproject.insurancesales.model.Client;
import com.insuranceproject.insurancesales.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * This class exposes the client objects to the REST API.
 */

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
    @GetMapping(path = "{id}")
    public Client getClientByID(@PathVariable("id") UUID id){
        return clientService.getClientById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteClientByID(@PathVariable("id") UUID id){
        clientService.deleteClient(id);
    }

    @PutMapping(path = "{id}")
    public void updateClient(@PathVariable("id") UUID id , @RequestBody Client clientToUpdate) {
        clientService.updateClient(id, clientToUpdate);
    }
}
