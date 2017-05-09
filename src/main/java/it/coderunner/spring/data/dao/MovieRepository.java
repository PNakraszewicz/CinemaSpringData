package it.coderunner.spring.data.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import it.coderunner.spring.data.model.Movie;

public interface MovieRepository extends CrudRepository<Movie, Long>{

	Movie findByTitleAllIgnoringCase(String title);
	
	List<Movie> findFirst10ByType(String type);
	List<Movie> findByShowsDateAfter(Date date);
	Page<Movie> findAll(Pageable pageable);
	
	@SuppressWarnings("unchecked")
	Movie save(Movie movie);

}