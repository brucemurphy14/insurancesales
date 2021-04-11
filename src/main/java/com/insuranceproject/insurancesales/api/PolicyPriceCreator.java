package com.insuranceproject.insurancesales.api;

import com.insuranceproject.insurancesales.dao.ClientJDBCDAO;
import com.insuranceproject.insurancesales.dao.DriverRiskFactorsJDBCDAO;
import com.insuranceproject.insurancesales.dao.HomeRiskFactorsJDBCDAO;
import com.insuranceproject.insurancesales.dao.PolicyDAO;
import com.insuranceproject.insurancesales.model.DriverRiskFactors;
import com.insuranceproject.insurancesales.model.HomeRiskFactors;
import com.insuranceproject.insurancesales.model.Policy_Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PolicyPriceCreator {

    @Autowired
    private ClientJDBCDAO clientJDBCDAO;
    @Autowired
    private HomeRiskFactorsJDBCDAO homeRiskFactorsDAO;
    @Autowired
    private DriverRiskFactorsJDBCDAO driverRiskFactorsJDBCDAO;
    @Autowired
    private PolicyDAO policyDAO;
    @Autowired
    private Policy_Factory policy_factory;

    public PolicyPriceCreator(HomeRiskFactorsJDBCDAO homeRiskFactorsDAO, DriverRiskFactorsJDBCDAO driverRiskFactorsJDBCDAO, PolicyDAO policyDAO, Policy_Factory policy_factory, ClientJDBCDAO clientJDBCDAO) {
        this.homeRiskFactorsDAO = homeRiskFactorsDAO;
        this.driverRiskFactorsJDBCDAO = driverRiskFactorsJDBCDAO;
        this.policyDAO = policyDAO;
        this.policy_factory = policy_factory;
        this.clientJDBCDAO = clientJDBCDAO;
    }

    public void updatePolicyTableTermPrice(String policyType, int policy_number){


        if (policyType.equals("Home")){

            Optional<HomeRiskFactors> homeRiskFactors = homeRiskFactorsDAO.get(1);
           // System.out.println(homeRiskFactors.isPresent());

          HomeRiskFactors calculatedRate = policy_factory.generateHomeRate(homeRiskFactors.orElse(null));
          System.out.println(calculatedRate.getCalculatedPremium());
           policyDAO.updateTermPrice(calculatedRate.getCalculatedPremium(), policy_number);


        }
        else if (policyType.equals("Auto")){
            Optional<DriverRiskFactors> driverRiskFactors =  driverRiskFactorsJDBCDAO.get(1);
            System.out.println(driverRiskFactors.isPresent());
            DriverRiskFactors calculatedRate = policy_factory.generateAutoRate(driverRiskFactors.orElse(null));
            System.out.println(calculatedRate.getCalculatedPremium());
       //     System.out.println(driverRiskFactors.orElse(null).getCalculatedPremium());
            policyDAO.updateTermPrice(calculatedRate.getCalculatedPremium(), policy_number);
        }
    }

    public void updateClientPolicyNumber(int client_id, String policyType, int policyNumber){
        clientJDBCDAO.updatePolicyField(client_id, policyType, policyNumber);
    }


}
