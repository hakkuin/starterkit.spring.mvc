package pl.spring.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.spring.demo.constants.ModelConstants;
import pl.spring.demo.constants.ViewNames;

/**
 * Controller class for home related pages
 * 
 * @author PPATRONI
 *
 */
@Controller
public class HomeController {
	
	private static final String WELCOME = "Dat is a welcome page!";
	private static final String INFO_TEXT = "Here You shall display information containing informations about whatever your heart desires!";

	/**
	 * Method controls welcome page display
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/")
	public String welcome(Model model) {
		model.addAttribute(ModelConstants.GREETING, WELCOME);
		model.addAttribute(ModelConstants.INFO, INFO_TEXT);
		return ViewNames.WELCOME;
	}
}
