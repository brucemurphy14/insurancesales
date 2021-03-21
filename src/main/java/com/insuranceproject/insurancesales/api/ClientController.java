package com.insuranceproject.insurancesales.api;

import com.insuranceproject.insurancesales.dao.ClientJDBCDAO;
import com.insuranceproject.insurancesales.model.Client;
import com.insuranceproject.insurancesales.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * This class exposes the client objects to the REST API.
 */


@RequestMapping("api/client")
@RestController
public class ClientController {
    private   ClientJDBCDAO clientDAO;

    @Autowired
    public ClientController(ClientService clientService, ClientJDBCDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    @PostMapping
    public void addClient(@RequestBody Client client){
        clientDAO.create(client);
    }

    @GetMapping
    public List<Client> selectAllClients(){
        return clientDAO.list();
    }

    @GetMapping(path = "{id}")
    public Client getClientByID(@PathVariable("id") int id){
        return clientDAO.get(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteClientByID(@PathVariable("id") int id){
        clientDAO.delete(id);
    }

    @PutMapping(path = "{id}")
    public void updateClient(@PathVariable("id") int id , @RequestBody Client clientToUpdate) {
        clientDAO.update(clientToUpdate, id );
    }
}
