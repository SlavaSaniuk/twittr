package by.bsac.services;

import by.bsac.data.dao.UserDao;
import by.bsac.exceptions.SignException;
import by.bsac.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class SignService {

    @Autowired
    private UserDao userDao; //User DAO used for retrieve information about users from database.

    /**
     * Authenticated user in system. Retrieve information from database and compare passwords.
     * @param a_user - user model with specified input values.
     * @return - User ID (if authentication process was successful.
     * @throws SignException - Caught if user with specified email don't register in system,
     *      or passwords aren't equals.
     */
    public int authenticate(User a_user) throws SignException {

        //Get user model from database by email:
        User reg_user = this.userDao.findByEmail(a_user.getUserEmail());

        //Check on if user exist in database:
        //If don't exist
        //throw new exception:
        if(reg_user == null)
            throw new SignException("User with specified email is not registered");

        //Compare passwords:
        //If don't equals
        //throw new exception:
        if(!reg_user.getUserPassword().equals(a_user.getUserPassword()))
            throw new SignException("Password are incorrect");

        System.out.println(reg_user.toString() +" logged in.");
        //If passwords are equals:
        //return user_id:
        return reg_user.getUserId();

    }

    public int registrate(User a_user) throws SignException {
        return 0;
    }

}
