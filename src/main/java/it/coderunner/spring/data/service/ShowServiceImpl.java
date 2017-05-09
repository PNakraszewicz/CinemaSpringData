package it.coderunner.spring.data.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.coderunner.spring.data.dao.ShowRepository;
import it.coderunner.spring.data.model.Show;

public class ShowServiceImpl implements ShowService {

	private static final long serialVersionUID = 1L;

	@Resource
	private ShowRepository ShowRepository;
	@Override
	public Show findByShowId(int showId) {
		return ShowRepository.findByShowId(showId);
	}

	@Override
	public Page<Show> findAll(Pageable pageable) {
		return ShowRepository.findAll(pageable);
	}

	@Override
	public Page<Show> findByRoomNumberContainingAllIgnoringCase(String number, Pageable pageable) {
		return ShowRepository.findByRoomNumberContainingAllIgnoringCase(number, pageable);
	}

	@Override
	public List<Show> findByDateAfter(Date date) {
		return ShowRepository.findByDateAfter(date);
	}

	@Override
	public Show save(Show show) {
		return ShowRepository.save(show);
	}

}
