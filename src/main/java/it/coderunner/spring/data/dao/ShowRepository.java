package it.coderunner.spring.data.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import it.coderunner.spring.data.model.Show;

public interface ShowRepository extends CrudRepository<Show, Long>{
	
	Page<Show> findAll(Pageable pageable);
	
	Page<Show> findByRoomNumberContainingAllIgnoringCase(
			String number, Pageable pageable);
	
	Show findByShowId(int showId);
	
	List<Show> findByDateAfter(Date date);
	
	@SuppressWarnings("unchecked")
	Show save(Show Show);

}