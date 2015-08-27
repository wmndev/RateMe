package com.eyooya.app;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eyooya.app.web.api.internal.controller.form.UserDetails;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);


	private Facebook facebook;

	//
	// @Inject
	// public HomeController(Facebook facebook) {
	// this.facebook = facebook;
	// }

	@RequestMapping(value = { "/", "home" }, method = RequestMethod.GET)
	public String helloFacebook(Model model) {

		/**
		 * Long id, String name, String title, List<String> tags, String
		 * category, String type, float rating, Point location, String zip,
		 * String address, String country, String state
		 */


		// facebook = new FacebookT
		// if (true) {
		// return "redirect:/auth/facebook";
		// }

		// model.addAttribute(facebook.userOperations().getUserProfile());
		// PagedList<Post> homeFeed = facebook.feedOperations().getHomeFeed();
		// model.addAttribute("feed", homeFeed);
		UserDetails userDetails = new UserDetails();
		model.addAttribute("userSecurity", userDetails);
		return "home";
	}



	@RequestMapping(value = "/logon", method = RequestMethod.GET)
	public String toLogon() {
		return "logon";
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	// @RequestMapping(value = "/", method = RequestMethod.GET)
	// public String home(Locale locale, Model model) {
	// logger.info("Welcome home! The client locale is {}.", locale);
	//
	// Date date = new Date();
	// DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
	// DateFormat.LONG, locale);
	//
	// String formattedDate = dateFormat.format(date);
	//
	// model.addAttribute("serverTime", formattedDate );
	//
	//
	// BusinessEntity e = new BusinessEntity();
	// e.setId(1);
	// e.setDescription("test");
	// // bService.insert(e);
	//
	// return "home";
	// }

}
