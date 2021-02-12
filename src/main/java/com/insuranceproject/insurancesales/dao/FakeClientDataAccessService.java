package com.insuranceproject.insurancesales.dao;

import com.insuranceproject.insurancesales.model.Client;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("fakeDAO")
public class FakeClientDataAccessService  implements ClientDAO {

    private static List<Client> DB = new ArrayList<>();


    @Override
    public List<Client> selectAllClients() {
        return DB;
    }

    @Override
    public int insertClient(UUID client_id, Client client) {
        DB.add(new Client(client_id, client.getMain_insured_name()));
        return 1;
    }

}
