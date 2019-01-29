package by.bsac.services.dao;

import by.bsac.models.User;

import java.util.List;

/**
 * User DAO.
 * Class which implements this interface must have of all CRUD operations.
 */
public interface UserDAO {

    /** Interface methods */
    /**
     * Method
     * @return
     */
    List<User> findAll();
    User findByID(Integer a_id);
    List<User> findByFirstName(String a_first_name);
    List<User> findByLastName(String a_last_name);
    User findByEmail(String a_email);
    void create(User a_user);
    void update(User a_user);
    void delete(User a_user);

}
