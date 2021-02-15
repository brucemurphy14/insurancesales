package com.insuranceproject.insurancesales.dao;

import java.util.List;
import java.util.Optional;

/**
 * This interface shows the required behaviour for the objects in the relational model.
 */
public interface DAO<T> {
    List<T> list() ;
    void create(T t);
    Optional<T> get(int id);
    void update(T object, int ID);
    void delete(int id);
}
