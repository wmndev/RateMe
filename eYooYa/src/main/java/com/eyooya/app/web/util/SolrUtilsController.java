package com.eyooya.app.web.util;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.geo.Point;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eyooya.app.platform.solr.core.base.service.MemberSolrIndexService;
import com.eyooya.app.web.api.internal.controller.form.UserDetails;

@RestController
@RequestMapping(value = "/solr")
public class SolrUtilsController { 

	
	@Autowired
	private static final Logger logger = LoggerFactory
			.getLogger(SolrUtilsController.class);
	@Autowired
	private MemberSolrIndexService memberSolrService;

	@RequestMapping(value = "/import", method = RequestMethod.GET)
	public void importToSolr(Model model) {
		logger.info("Start importing to Solr...");
		for (int i = 0; i < 7; i++) {
			memberSolrService
					.addToIndex(System.currentTimeMillis(), getName(i),
							getTitle(i), getTags(i), getCategory(i),
							i % 2 == 0 ? "employee" : "business",
							(float) (i % 5 + 2.5), new Point(40.782604,-73.950677),
							getZip(i), ((i + 7) + " East " + i + " Street"),
							"United States", "NY");

		}
		logger.info("Done importing to Solr");
		UserDetails userDetails = new UserDetails();
		model.addAttribute("userSecurity", userDetails);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteFromSolrByName(@PathVariable("id") long id, Model model) {
		logger.info("Deleting from Solr, record id:"+id);
		memberSolrService.deleteFromIndex(id);
		UserDetails userDetails = new UserDetails();
		model.addAttribute("userSecurity", userDetails);
		return "/home";
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

}
