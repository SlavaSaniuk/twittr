package by.bsac.data.dao;

import by.bsac.models.User;

/**
 * Interface for data access to users rows in database.
 * Implements all CRUD operations.
 */
public interface UserDao extends Dao<User> {

    /* Interface methods */

    /**
     * Find user object row in database by 'user_id' field.
     * @param a_id - value od user ID.
     * @return - Single user object (user_id must be a unique).
     */
    User findById(int a_id);

    /**
     * Find user object row in database by 'user_email' field.
     * @param a_email - user email address.
     * @return - Single user object (user_email must be a unique).
     */
    User findByEmail(String a_email);
}
