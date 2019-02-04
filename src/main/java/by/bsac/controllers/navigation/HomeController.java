package by.bsac.controllers.navigation;

import by.bsac.exceptions.SignException;
import by.bsac.models.User;
import by.bsac.services.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;

/**
 *  Return a home page ("login.html").
 */
@Controller
@RequestMapping("/")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class HomeController {

    @Autowired
    private SignService sign_service; // Sign service used for authenticate user in system.
    private final String home_page = "home"; //This view name.


    /**
     * Method used for handing GET request to home page.
     * @param a_model - model for view.
     * @return - String - logical view name.
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getHomePage(Model a_model) {
        a_model.addAttribute("user", new User());
        return this.home_page;
    }

    /**
     * Method used for authenticate user.
     * @param a_user - user inputs from login form.
     * @return - String - logical view name.
     */
    @RequestMapping(method = RequestMethod.POST)
    public String processLoginRequest(User a_user) {

        try {

            this.sign_service.authenticate(a_user);

        } catch (SignException exc) {
            System.out.println(exc.getMessage());
        }

        return "user";
    }

}
