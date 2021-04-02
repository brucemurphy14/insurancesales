package com.insuranceproject.insurancesales.api;

import com.insuranceproject.insurancesales.dao.Auto_PolicyJDbcdao;
import com.insuranceproject.insurancesales.model.Auto_Policy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * API access point for auto_policy table.
 */
@RequestMapping("api/auto_policy")
@RestController
public class Auto_PolicyController {
    private final Auto_PolicyJDbcdao autoPolicyJDbcdao;

    @Autowired
    public Auto_PolicyController(Auto_PolicyJDbcdao autoPolicyJDbcdao) {
        this.autoPolicyJDbcdao = autoPolicyJDbcdao;
    }

    @PostMapping
    public void addAuto_Policy(@RequestBody Auto_Policy auto_policy) {
        autoPolicyJDbcdao.create(auto_policy);
    }

    @GetMapping
    public List<Auto_Policy> selectAllAutoPolicy() {
        return autoPolicyJDbcdao.list();
    }

    @GetMapping(path = "{id}")
    public Auto_Policy getAutoPolicyByID(@PathVariable("id") int id) {
        return autoPolicyJDbcdao.get(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteAutoPolicyByID(@PathVariable("id") int id) {
        autoPolicyJDbcdao.delete(id);
    }

    @PutMapping(path = "{id}")
    public void updateClient(@PathVariable("id") int id, @RequestBody Auto_Policy autoPolicyToUpdate) {
        autoPolicyJDbcdao.update(autoPolicyToUpdate, id);
    }
}