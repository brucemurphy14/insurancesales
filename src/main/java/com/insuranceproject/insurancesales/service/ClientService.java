package com.insuranceproject.insurancesales.service;

import com.insuranceproject.insurancesales.dao.ClientDAO;
import com.insuranceproject.insurancesales.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientDAO clientDAO;

    @Autowired
    public ClientService(@Qualifier("fakeDAO")ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    public int addClient(Client client){
        return clientDAO.insertClient(client);

    }


    public List<Client> getAllClients(){
        return clientDAO.selectAllClients();
    }




}
