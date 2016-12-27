package no.uio.neo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class BaseController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(ModelMap model) {
	// Spring uses InternalResourceViewResolver and return back index.jsp
	return "index";
    }

}
