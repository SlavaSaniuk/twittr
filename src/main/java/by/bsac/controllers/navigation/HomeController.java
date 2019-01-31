package by.bsac.controllers.navigation;

import by.bsac.data.dao.UserDAO;
import by.bsac.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *  Return a home page ("login.html").
 */
@Controller
@RequestMapping({ "/", "index.*" })
public class HomeController {

    /* Class global variables */
    private UserDAO user_dao;

    /* Class constructors */
    /**
     * Create Home page controller.
     * @param a_user_dao - User DAO object for authentication purposes.
     */
    @Autowired
    public HomeController(UserDAO a_user_dao) {

        //Mapping args
        this.user_dao = a_user_dao;

    }

    /**
     * Method used for handing GET request to home page.
     * @param a_model - model for view.
     * @return - String - logical view name.
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getHomePage(Model a_model) {
        a_model.addAttribute("user", new User());
        return "home";
    }

    /**
     * Method used for handing POST request to home page.
     * @param a_user - user inputs from login form.
     * @return - String - logical view name.
     */
    @RequestMapping(method = RequestMethod.POST)
    public String processLoginRequest(User a_user) {

        //Check email and password
        if(!this.autenticate(a_user)) return "redirect:/";

        return "User";
    }






    private boolean autenticate(User a_user) {

        //Get user data from database:
        User registered_user = this.user_dao.findByEmail(a_user.getUserEmail());

        //Check at null:
        if (registered_user == null) return false;

        //Compare passwords:
        // If all OK, return true.
        return registered_user.getUserPassword().equals(a_user.getUserPassword());
    }


}
