package by.bsac.data.dao;

import java.util.List;

/**
 *  Common interface for data access object operations.
 *  param <T> - model for handing by CRUD operations.
 */
public interface Dao<T> {

    /* Interface methods */

    /**
     * Find all model objects saved in database.
     * "SELECT" operation.
     * @return - List of all founded <T> objects.
     */
    List<T> findAll();

    /**
     * Create a <T> model object row in database.
     * "INSERT" operation.
     * @param t - model object that needs to be saved.
     */
    void create(T t);

    /**
     * Update a <T> model object row in database.
     * "UPDATE" operation.
     * @param t - model object that needs to be updated.
     */
    void update(T t);

    /**
     * Delete a <T> model object row in database.
     * "DELETE" operation.
     * @param t - model object that needs to de deleted.
     */
    void delete(T t);

}
