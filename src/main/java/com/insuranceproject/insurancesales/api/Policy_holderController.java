package com.insuranceproject.insurancesales.api;

import com.insuranceproject.insurancesales.dao.ClientJDBCDAO;
import com.insuranceproject.insurancesales.dao.PolicyDAO;
import com.insuranceproject.insurancesales.dao.Policy_HolderJDBCDAO;
import com.insuranceproject.insurancesales.model.Policy_Holder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("api/policy_holder")
@RestController
public class Policy_holderController {
    private final Policy_HolderJDBCDAO policy_holderJDBCDAO;
    private final PolicyDAO policyDAO;
    private final HomeRateCalculatorController homeRateCalculatorController;
    private final PolicyPriceCreator policyPriceCreator;
    private final ClientJDBCDAO clientjdbcdao;

    @Autowired
    public Policy_holderController(Policy_HolderJDBCDAO policy_holderJDBCDAO, PolicyDAO policyDAO, HomeRateCalculatorController homeRateCalculatorController, PolicyPriceCreator policyPriceCreator, ClientJDBCDAO clientjdbcdao) {
        this.policy_holderJDBCDAO = policy_holderJDBCDAO;
        this.policyDAO = policyDAO;
        this.homeRateCalculatorController = homeRateCalculatorController;
        this.policyPriceCreator = policyPriceCreator;
        this.clientjdbcdao = clientjdbcdao;
    }

    @PostMapping
    public void addPolicyHolder(/*@RequestBody Policy_Holder policy_holder*/) {
     //   policy_holderJDBCDAO.createNoParam(policy_holder);
        policy_holderJDBCDAO.createNoParam();


        String policyType = policyDAO.returnNewestPolicyType();
        int policyNumber = policyDAO.returnNewestPolicyNumber();
       // System.out.println(policyType);
       // System.out.println(policyNumber);
        policyPriceCreator.updatePolicyTableTermPrice(policyType, policyNumber);
        policyPriceCreator.updateClientPolicyNumber(clientjdbcdao.returnCurrentClientID(),policyType,policyNumber);

    }

    public void insertPolicyPremium(float premium){
        policyDAO.update(premium);
    }

    @GetMapping
    public List<Policy_Holder> selectAllPolicyHolder() {
        return policy_holderJDBCDAO.list();
    }

    @GetMapping(path = "{id}")
    public Policy_Holder getPolicyHolderByID(@PathVariable("id") int id) {
        return policy_holderJDBCDAO.get(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePolicyHolderByID(@PathVariable("id") int id) {
        policy_holderJDBCDAO.delete(id);
    }

    @PutMapping(path = "{id}")
    public void updateClient(@PathVariable("id") int id, @RequestBody Policy_Holder policyHolderToUpdate) {
        policy_holderJDBCDAO.update(policyHolderToUpdate, id);
    }
}