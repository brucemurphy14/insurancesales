package com.insuranceproject.insurancesales.api;

import com.insuranceproject.insurancesales.dao.PolicyDAO;
import com.insuranceproject.insurancesales.model.Policy;
import com.insuranceproject.insurancesales.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST endpoint for the cars table.
 */
@RequestMapping("api/policy")
@RestController
public class PolicyController {
    private final PolicyDAO policyJDBCDAO;

    @Autowired
    public PolicyController(ClientService clientService, PolicyDAO policyJDBCDAO) {
        this.policyJDBCDAO = policyJDBCDAO;
    }

    @PostMapping
    public void addPolicy(@RequestBody Policy policy) {
        policyJDBCDAO.create(policy);
    }

    @GetMapping
    public List<Policy> selectAllPolicy() {
        return policyJDBCDAO.list();
    }

    @GetMapping(path = "policy/{id}")
    public Policy getPolicyByID(@PathVariable("id") int id) {
        return policyJDBCDAO.get(id)
                .orElse(null);
    }

    @DeleteMapping(path = "policy/{id}")
    public void deletePolicyByID(@PathVariable("id") int id) {
        policyJDBCDAO.delete(id);
    }

    @PutMapping(path = "policy/{id}")
    public void updatePolicyPrice(@PathVariable("id") int id, @RequestBody Policy policyToUpdate) {
        policyJDBCDAO.update(policyToUpdate, id);
    }

    public void updatePolicyTermPrice(float termPrice) {
        policyJDBCDAO.update(termPrice);
    }
}