package com.truongnv.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.truongnv.service.JenaService;
import com.truongnv.model.PersonModel;
import com.truongnv.model.PostModel;


@Controller
public class IndexController {
	JenaService jenaService = new JenaService();

	@GetMapping("/")
	public String indexPage(Model model) {
		return "search-form";
	}

	@GetMapping("/search")
	public String searchPage(Model model, @RequestParam(name = "uri", required = false) String uri) {
		if (uri == null)
			return "search-form";

		model.addAttribute("uri", uri);

		if (jenaService.checkPerson(uri)) {
			PersonModel person = jenaService.searchPersonByUri(uri);
			if (person != null) {
				model.addAttribute("person", person);
				return "search-person-form";
			} else {
				return "search-404-form";
			}

		} else {
			PostModel post = jenaService.searchPostModelByUri(uri);
			if (post != null) {
				model.addAttribute("post", post);
				return "search-post-form";
			} else {
				return "search-404-form";
			}

		}
	}

}
