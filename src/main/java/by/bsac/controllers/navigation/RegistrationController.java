package by.bsac.controllers.navigation;

import by.bsac.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 */
@Controller
@RequestMapping("/registration")
public class RegistrationController {

    /** Class methods */
    @RequestMapping(method = RequestMethod.GET)
    public String getRegistrationPage(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String registrerUser(@ModelAttribute User user) {
        return "/";
    }



}
