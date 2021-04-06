package com.insuranceproject.insurancesales.dao;

import java.util.List;
import java.util.Optional;

/**
 * This interface shows the required behaviour for the POJO objects.
 */
public interface DAO<T> {

    /**
     * List all objects limited by username currently logged in
     * @return
     */
    List<T> list();

    /**
     * Creates a new row in the database.
     * @param t the pojo for the table
     */
    void create(T t);

    /**
     * Creates a new row in a table and returns the auto incremented primary key from it.
     * @param t
     * @return
     */

    int createAndReturnAutoKey(T t);

    /**
     * Retrieves a particular row from the database.
     * @param id usually client_id to get information on a single client
     * @return a pojo of the table row
     */
    Optional<T> get(int id);

    /**
     * Updates data in the table.
     * @param object the pojo for the table to be updated
     * @param ID the row that should be updated
     */
    void update(T object, int ID);

    /**
     * Deletes a row from the database.
     * @param id the row to be deleted.
     */
    void delete(int id);
}
