package it.coderunner.spring.data.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.coderunner.spring.data.model.Show;

public interface ShowService extends Serializable {
	
	Show findByShowId(int showId);
	Page<Show> findAll(Pageable pageable);
	Page<Show> findByRoomNumberContainingAllIgnoringCase(String number, Pageable pageable);

	List<Show> findByDateAfter(Date date);

	Show save(Show Show);

}
