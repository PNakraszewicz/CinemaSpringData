package it.coderunner.spring.data.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.coderunner.spring.data.dao.MovieRepository;
import it.coderunner.spring.data.model.Movie;

@Service
public class MovieServiceImpl implements MovieService{

	private static final long serialVersionUID = -5212497294563141450L;
	
	@Resource
	private MovieRepository MovieRepository;

	@Override
	public List<Movie> findFirst10ByType(String type) {
		return MovieRepository.findFirst10ByType(type) ;
	}
	
	@Override
	public List<Movie> findByShowsDateAfter(Date date) {
		return MovieRepository.findByShowsDateAfter(date);
	}
	@Override
	public Page<Movie> findAll(Pageable pageable) {
		return MovieRepository.findAll(pageable);
	}
	@Override
	public Movie findByTitleAllIgnoringCase(String title) {
		return MovieRepository.findByTitleAllIgnoringCase(title);
	}
	@Override
	public Movie save(Movie movie) {
		return MovieRepository.save(movie);
	}


}