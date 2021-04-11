package com.insuranceproject.insurancesales.api;

import com.insuranceproject.insurancesales.dao.Home_PolicyJDBCDAO;
import com.insuranceproject.insurancesales.model.Home_Policy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * API access point for auto_policy table.
 */
@RequestMapping("api/home_policy")
@RestController
public class Home_PolicyController {
    private final Home_PolicyJDBCDAO homePolicyJDbcdao;

    @Autowired
    public Home_PolicyController(Home_PolicyJDBCDAO homePolicyJDbcdao) {
        this.homePolicyJDbcdao = homePolicyJDbcdao;
    }

    @PostMapping
    public void addHome_Policy(/*@RequestBody Home_Policy home_policy*/) {
      //  homePolicyJDbcdao.create(home_policy);
          homePolicyJDbcdao.createNoParam();

    }

    @GetMapping
    public List<Home_Policy> selectAllHomePolicy() {
        return homePolicyJDbcdao.list();
    }

    @GetMapping(path = "{id}")
    public Home_Policy getHomePolicyByID(@PathVariable("id") int id) {
        return homePolicyJDbcdao.get(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteHomePolicyByID(@PathVariable("id") int id) {
        homePolicyJDbcdao.delete(id);
    }

    @PutMapping(path = "{id}")
    public void updateHomePolicy(@PathVariable("id") int id, @RequestBody Home_Policy homePolicyToUpdate) {
        homePolicyJDbcdao.update(homePolicyToUpdate, id);
    }
}