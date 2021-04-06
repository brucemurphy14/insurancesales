package com.insuranceproject.insurancesales.model;

import com.insuranceproject.insurancesales.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class ConfirmedPolicy {
    @Autowired
    AccidentListingJDBCDAO accidentListingJDBCDAO;
    @Autowired
    AddressJDBCDAO addressJDBCDAO;
    @Autowired
    ClientJDBCDAO clientJDBCDAO;
    @Autowired
    PolicyDAO policyDAO;
    @Autowired
    Policy_HolderJDBCDAO policy_holderJDBCDAO;
    @Autowired
    Auto_PolicyJDbcdao autoPolicyJDbcdao;
    @Autowired
    UserJDBCDAO userJDBCDAO;

    public ConfirmedPolicy(AccidentListingJDBCDAO accidentListingJDBCDAO, AddressJDBCDAO addressJDBCDAO, ClientJDBCDAO clientJDBCDAO, PolicyDAO policyDAO, Policy_HolderJDBCDAO policy_holderJDBCDAO, Auto_PolicyJDbcdao autoPolicyJDbcdao) {
        this.accidentListingJDBCDAO = accidentListingJDBCDAO;
        this.addressJDBCDAO = addressJDBCDAO;
        this.clientJDBCDAO = clientJDBCDAO;
        this.policyDAO = policyDAO;
        this.policy_holderJDBCDAO = policy_holderJDBCDAO;
        this.autoPolicyJDbcdao = autoPolicyJDbcdao;
    }

    public void insertAutoPolicyIntoTables(Client client, AccidentListing accidentListing, Address address,Policy policy, Policy_Holder policy_holder, Auto_Policy auto_policy){

          int address_id =   addressJDBCDAO.createAndReturnAutoKey(address);
         int client_id =  clientJDBCDAO.createAndReturnAutoKey(client);





    }

}
