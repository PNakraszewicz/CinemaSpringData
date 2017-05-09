package it.coderunner.spring.data.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import it.coderunner.spring.data.model.Movie;
import it.coderunner.spring.data.service.MovieService;

@Controller
public class MovieController {

	@Autowired
	private MovieService movieService;

	@GetMapping("/getMovie/Movie/{title}")
	public @ResponseBody ResponseEntity<String> getByTitle(@PathVariable String title) {
		Movie Movie = movieService.findByTitleAllIgnoringCase(title);
		return Movie != null ? new ResponseEntity<String>("GET Response : " + Movie, HttpStatus.OK)
				: new ResponseEntity<String>("No Movie found", HttpStatus.NOT_FOUND);
	}

	@GetMapping("/saveMovie/Movie/{title}/{type}")
	public @ResponseBody ResponseEntity<String> saveMovie(@PathVariable String title, 
			@PathVariable String type) {
		Movie Movie = movieService.save(new Movie(title, type));
		return Movie != null ? new ResponseEntity<String>("GET Response : " + Movie, HttpStatus.OK)
				: new ResponseEntity<String>("Problem with saving", HttpStatus.NOT_FOUND);
	}

	@GetMapping("/getMovie/top10/{type}")
	public @ResponseBody ResponseEntity<String> getTop10(@PathVariable String type) {
		List<Movie> Movies = movieService.findFirst10ByType(type);
		Movies.stream().forEach(System.out::println);
		return Movies != null && !Movies.isEmpty()
				? new ResponseEntity<String>("GET Response : " + Movies, HttpStatus.OK)
				: new ResponseEntity<String>("No Movie found", HttpStatus.NOT_FOUND);
	}

	@GetMapping("/getMovie/all/{page}/{size}")
	public @ResponseBody Page<Movie> getTop10(@PathVariable Integer page, @PathVariable Integer size) {
		return movieService.findAll(new PageRequest(page, size));
	}
	
	@GetMapping("/getMovie/after/{date}")
	public @ResponseBody ResponseEntity<String> getAfter(@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") Date date) {
		List<Movie> Movies = movieService.findByShowsDateAfter(date);
		Movies.stream().forEach(System.out::println);
		return Movies != null && !Movies.isEmpty()
				? new ResponseEntity<String>("GET Response : " + Movies, HttpStatus.OK)
				: new ResponseEntity<String>("No Movie found", HttpStatus.NOT_FOUND);
	}
}

