package com.insuranceproject.insurancesales.api;

import com.insuranceproject.insurancesales.dao.AddressJDBCDAO;
import com.insuranceproject.insurancesales.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/address")
@RestController
public class AddressController {
    private final AddressJDBCDAO addressDAO;

    @Autowired
    public AddressController(AddressJDBCDAO addressDAO) {
        this.addressDAO = addressDAO;
    }

    @PostMapping
    public void addAddress(@RequestBody Address address) {
       addressDAO.create(address);
    }

    @GetMapping
    public List<Address> selectAllAddress() {
        return addressDAO.list();
    }

    @GetMapping(path = "{id}")
    public Address getAddressByID(@PathVariable("id") int id) {
        return addressDAO.get(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteAddressByID(@PathVariable("id") int id) {
        addressDAO.delete(id);
    }

    @PutMapping(path = "{id}")
    public void updateAddress(@PathVariable("id") int id, @RequestBody Address addressToUpdate) {
        addressDAO.update(addressToUpdate, id);
    }
}