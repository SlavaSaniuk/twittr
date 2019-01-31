package by.bsac.data.dao;

import by.bsac.models.User;

import java.util.List;

/**
 * User DAO.
 * Class which implements this interface must have of all CRUD operations.
 */
public interface UserDAO {

    /**
     * Method get data about of all users in database.
     * @return - list of users.
     */
    List<User> findAll();

    /**
     * Method search data about user by his ID in database.
     * @param a_id - User ID.
     * @return - specific user object.
     */
    User findByID(Integer a_id);

    /**
     * Method search data about user by his first name in database.
     * @param a_first_name - User first name.
     * @return - specific list of user object.
     */
    List<User> findByFirstName(String a_first_name);

    /**
     * Method search data about user by his last name in database.
     * @param a_last_name - User last name.
     * @return - specific list of user object.
     */
    List<User> findByLastName(String a_last_name);

    /**
     * Method search data about user by his email address in database.
     * @param a_email - User email address.
     * @return - specific user object.
     */
    User findByEmail(String a_email);

    /**
     * Method write data about specific user in database.
     * @param a_user - data of user (User object).
     */
    void create(User a_user);

    /**
     * Method change data about specific user in database.
     * @param a_user - data of user (User object).
     */
    void update(User a_user);

    /**
     * Method erase data about specific user in database.
     * @param a_user - data of user (User object).
     */
    void delete(User a_user);

}
