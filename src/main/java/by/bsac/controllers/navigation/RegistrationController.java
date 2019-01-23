package by.bsac.controllers.navigation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *  Return a registration page ("registration.html").
 */
@Controller
@RequestMapping("/registration")
public class RegistrationController {

    /** Class global variables */


    /** Class constructors */


    /** Class methods */
    @RequestMapping(method = RequestMethod.GET)
    public String getRegistrationPage() {
        return "registration";
    }

}
