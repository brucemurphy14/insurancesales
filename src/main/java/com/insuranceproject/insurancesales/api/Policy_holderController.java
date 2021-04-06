package com.insuranceproject.insurancesales.api;

import com.insuranceproject.insurancesales.dao.Policy_HolderJDBCDAO;
import com.insuranceproject.insurancesales.model.Policy_Holder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("api/policy_holder")
@RestController
public class Policy_holderController {
    private final Policy_HolderJDBCDAO policy_holderJDBCDAO;

    @Autowired
    public Policy_holderController(Policy_HolderJDBCDAO policy_holderJDBCDAO) {
        this.policy_holderJDBCDAO = policy_holderJDBCDAO;
    }

    @PostMapping
    public void addAuto_Policy(@RequestBody Policy_Holder policy_holder) {
        policy_holderJDBCDAO.create(policy_holder);
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