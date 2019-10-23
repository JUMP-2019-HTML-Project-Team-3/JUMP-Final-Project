package com.collabera.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.collabera.dto.MovieDTO;
import com.collabera.dto.StudioDTO;
import com.collabera.service.MovieService;

@RestController
@RequestMapping("/api")
public class MovieController {
	private final MovieService movieService;
 
	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}
 
     /**get all the movies for a given category**/
	@GetMapping("/movies")
	public List<MovieDTO> getAll(@RequestParam(name = "category", required = false) String category,@RequestParam(name = "related", required = false) boolean related, @RequestParam(name = "metadata", required = false) boolean metadata) {
		return movieService.findAll(category);
	}
 
/**get a movie for a given id **/
 
	@GetMapping("/movies/{id}")
	public ResponseEntity<MovieDTO> get(@PathVariable Long id) {
		MovieDTO movie = movieService.findOne(id);
		return ResponseEntity.ok(movie);
	}
 
/** create a new movie given the details **/
	@PostMapping("/movies")
	public ResponseEntity<MovieDTO> create(@RequestBody @Valid MovieDTO movie) throws URISyntaxException {
		MovieDTO result = movieService.save(movie);
		return ResponseEntity.created(new URI("/api/movies/" + result.getMovieId())).body(result);
	}
 
/** update a movie given details **/
	@PutMapping("/movies/{id}")
	public ResponseEntity<MovieDTO> updateJob(@PathVariable Long id, @RequestBody @Valid MovieDTO movie) {
		MovieDTO result = movieService.update(movie, id);
		return ResponseEntity.ok().body(result);
	}
 
/** delete a movie given the id **/
	@DeleteMapping("/movies/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		movieService.delete(id);
		return ResponseEntity.ok().build();
	}
/** get all the studios from the database **/
	@GetMapping("/studios")
	public ResponseEntity<List<StudioDTO>> getAll() {
		List<StudioDTO> result = movieService.findAllStudios();
		return ResponseEntity.ok().body(result);
	}
}

