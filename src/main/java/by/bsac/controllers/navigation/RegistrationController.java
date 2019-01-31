package by.bsac.controllers.navigation;

import by.bsac.data.dao.UserDAO;
import by.bsac.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 *
 */
@Controller("registrationController")
@RequestMapping("/registration")
public class RegistrationController {

    private UserDAO user_dao;

    @Autowired
    public RegistrationController(UserDAO user_dao) {
        this.user_dao = user_dao;
    }

    /** Class methods */
    @RequestMapping(method = RequestMethod.GET)
    public String getRegistrationPage(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String registerUser(User user) {

        this.register(user);
        return "redirect:/user";
    }

    private void register(User a_user) {
        this.user_dao.create(a_user);
    }


}
