package by.bsac.controllers.navigation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *  Return a home page ("login.html").
 */
@Controller
@RequestMapping({ "/", "index.*" })
public class HomeController {

    /** Class methods */
    @RequestMapping(method = RequestMethod.GET)
    public String getLoginPage() {
        return "login";
    }


}
