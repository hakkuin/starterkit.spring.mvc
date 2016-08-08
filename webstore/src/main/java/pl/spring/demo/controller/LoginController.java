package pl.spring.demo.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pl.spring.demo.constants.ViewNames;

/**
 * Controller class for login related pages
 * 
 * @author PPATRONI
 *
 */
@Controller
public class LoginController {

	/**
	 * Method controls login page display
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	/**
	 * Method controls login error page display 
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public String loginerror(Model model) {
		model.addAttribute("error", "true");
		return ViewNames.LOGIN;
	}

	/**
	 * Method controls logout page display
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model) {
		return ViewNames.LOGOUT;
	}

	/**
	 * Method controls 403 page display
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied(Principal user) {
		ModelAndView model = new ModelAndView();
		model.addObject("userName", user.getName());
		// TODO: implement mechanism redirecting to new custom page _403
		// (consider extending informations by custom values)
		return model;

	}
}
