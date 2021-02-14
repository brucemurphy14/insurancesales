package com.insuranceproject.insurancesales.dao;

import com.insuranceproject.insurancesales.model.Client;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * This interface shows the required behaviour for the client API.
 */
public interface DAO<T> {
    List<T> list() ;
    void create(T t);
    Optional<T> get(int id);
    void update(T object, int ID);
    void delete(int id);
}
