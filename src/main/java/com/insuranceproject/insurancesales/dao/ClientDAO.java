package com.insuranceproject.insurancesales.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.insuranceproject.insurancesales.model.Client;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientDAO {
    List<Client> selectAllClients() ;
    int deleteClientByID(UUID id);
    int updateClientById(UUID id, Client client);

    Optional<Client> selectClientByID(UUID id);

    int insertClient(UUID client_id, Client client);

     default int insertClient(Client client){
        UUID id =  UUID.randomUUID();
        return insertClient(id, client);
    }


}
