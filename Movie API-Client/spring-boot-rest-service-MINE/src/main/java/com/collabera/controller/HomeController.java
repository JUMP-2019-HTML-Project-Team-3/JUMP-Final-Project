package com.collabera.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.collabera.dto.UserDTO;

/**
 * Controller to serve the html pages
 */
@Controller
public class HomeController {

	/**
	 * method to serve the login page index.html
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/login")
	private String indexPage(Model model) {
		// adds an empty user object on the login page. The username and password will be added to this object
		model.addAttribute("user", new UserDTO());
		return "index";
	}

	/**
	 * method to serve the movie list page movie.html
	 * @return
	 */
	@RequestMapping(value = "/movie-list")
	private String movies() {
		return "movie";
	}

	/**
	 * method to show the add movie page add-movie.html
	 * @return
	 */
	@RequestMapping(value = "/add-movie")
	private String addMovie() {
		return "add-movie";
	}

	/**
	 * method to show the update movie page update-movie.html
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/update-movie")
	private String updateMovie(@RequestParam(name = "id") long id, Model model) {
		model.addAttribute("movieId", id);
		return "update-movie";
	}
}
