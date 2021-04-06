package com.insuranceproject.insurancesales.api;

import com.insuranceproject.insurancesales.dao.UserJDBCDAO;
import com.insuranceproject.insurancesales.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("api/user")
@RestController
public class UserController {
    private final UserJDBCDAO userJDbcdao;

    @Autowired
    public UserController(UserJDBCDAO userJDbcdao) {
        this.userJDbcdao = userJDbcdao;
    }

    @PostMapping
    public void addAuto_Policy(@RequestBody User user) {
        userJDbcdao.create(user);
    }

    @GetMapping
    public List<User> selectAllUsers() {
        return userJDbcdao.list();
    }

    @GetMapping(path = "{id}")
    public User getUserByID(@PathVariable("id") int id) {
        return userJDbcdao.get(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteUserByID(@PathVariable("id") int id) {
        userJDbcdao.delete(id);
    }

    @PutMapping(path = "{id}")
    public void updateClient(@PathVariable("id") int id, @RequestBody User userToUpdate) {
        userJDbcdao.update(userToUpdate, id);
    }
}
