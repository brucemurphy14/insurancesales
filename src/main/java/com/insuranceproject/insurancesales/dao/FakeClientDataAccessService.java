package com.insuranceproject.insurancesales.dao;

import com.insuranceproject.insurancesales.model.Client;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDAO")
public class FakeClientDataAccessService  implements ClientDAO {

    private static List<Client> DB = new ArrayList<>();


    @Override
    public List<Client> selectAllClients() {
        return DB;
    }

    @Override
    public int deleteClientByID(UUID id) {
        Optional <Client> clientMaybe = selectClientByID(id);
        if (clientMaybe.isEmpty()){
            return 0;
        }
        DB.remove(clientMaybe.get());
        return 1;
    }

    @Override
    public int updateClientById(UUID id, Client updatedClient) {

        return selectClientByID(id)
                .map(client -> {
                    int indexOfClientToUpdate = DB.indexOf(client);
                    if (indexOfClientToUpdate >= 0){
                        DB.set(indexOfClientToUpdate, new Client(id, updatedClient.getMain_insured_name()));
                        return 1;
                    }
                    return 0;
                }
                )
                .orElse(0);
    }

    @Override
    public Optional<Client> selectClientByID(UUID id) {
        return DB.stream()
                .filter(client -> client.getClient_id().equals(id))
                .findFirst();
    }

    @Override
    public int insertClient(UUID client_id, Client client) {
        DB.add(new Client(client_id, client.getMain_insured_name()));
        return 1;
    }

}
