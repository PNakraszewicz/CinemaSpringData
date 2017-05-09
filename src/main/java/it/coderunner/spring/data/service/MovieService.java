package it.coderunner.spring.data.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.coderunner.spring.data.model.Movie;

public interface MovieService extends Serializable{

	Movie findByTitleAllIgnoringCase(String title);

	List<Movie> findFirst10ByType(String type);
	List<Movie> findByShowsDateAfter(Date date);
	Page<Movie> findAll(Pageable pageable);
	 
	Movie save(Movie movie);
		

}
