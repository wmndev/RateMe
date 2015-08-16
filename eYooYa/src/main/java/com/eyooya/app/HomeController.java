package com.eyooya.app;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.geo.Point;

import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eyooya.app.platform.solr.core.base.document.MemberSolrDocument;
import com.eyooya.app.platform.solr.core.base.service.MemberSolrIndexService;
import com.eyooya.app.web.api.internal.controller.form.UserDetails;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@Autowired
	private MemberSolrIndexService empSolrService;

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
		for (int i = 0; i < 10; i++) {
			empSolrService.addToIndex(System.currentTimeMillis(), getName(i),
					getTitle(i), getTags(i), getCategory(i),
					i % 2 == 0 ? "employee" : "business", (float) (i % 5 + 2.5),
					new Point(i * 12, i % 2 + 67), getZip(i), ((i + 7)
							+ " East " + i + " Street"), "United States", "NY");

		}

		// empSolrService.addToIndex(123456l, "Software Engineer",
		// "java, ruby, spring");
		long t1 = System.currentTimeMillis();
		List<MemberSolrDocument> docs = empSolrService.getDocByTags("ruby");
		if (docs != null && !docs.isEmpty()) {
			// System.out.println("==== "+ docs.get(0).getJobTitle());

		}
		long res = System.currentTimeMillis() - t1;
		System.out.println("docs by ruby: " + res);
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

	private String getZip(int i) {
		int mod = i % 4;
		switch (mod) {
		case 0:
			return "10128";
		case 1:
			return "10019";
		case 2:
			return "10017";
		case 3:
			return "10036";

		}
		return "10016";
	}

	private String getCategory(int i) {
		int mod = i % 4;
		switch (mod) {
		case 0:
			return "Personal Trainer";
		case 1:
			return "Barber";
		case 2:
			return "Medicore Proffesional";
		case 3:
			return "Yoga Trainer";

		}
		return "Driver";
	}

	private String getName(int i) {
		int mod = i % 4;
		switch (mod) {
		case 0:
			return "Itay Wiseman";
		case 1:
			return "Momo Shmuel";
		case 2:
			return "Jacky Robin";
		case 3:
			return "Hilik Jonson";

		}
		return "Mister Big";
	}

	private List<String> getTags(int i) {
		int mod = i % 4;
		List<String> res = new ArrayList<>();
		switch (mod) {
		case 0:
			res.add("funny");
			res.add("dfdfd");
			res.add("fffff");
			res.add("nnnnn");
			return res;
		case 1:
			res.add("qqqq");
			res.add("eeee");
			res.add("rrrr");
			res.add("bbbb");
			return res;
		case 2:
			res.add("oooo");
			res.add("ppppp");
			res.add("mmmmm");
			res.add("zzzzz");
			return res;
		case 3:
			res.add("aaaaa");
			res.add("sssss");
			res.add("fffff");
			res.add("wwwww");
			return res;
		}
		return res;
	}

	private String getTitle(int i) {
		int mod = i % 4;
		switch (mod) {
		case 0:
			return "Doctor momo";
		case 1:
			return "Special Teacher";
		case 2:
			return "Supply Manager";
		case 3:
			return "Software Team Leader";
		default:
			return "Zevel shel Ben Adam";
		}
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
