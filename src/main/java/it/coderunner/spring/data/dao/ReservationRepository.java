package it.coderunner.spring.data.dao;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import it.coderunner.spring.data.model.Reservation;

public interface ReservationRepository extends CrudRepository<Reservation, Long>{
	
	Page<Reservation> findAll(Pageable pageable);

	Page<Reservation> findByEmailContainingAndNameContainingAllIgnoringCase(String email,
			String name, Pageable pageable);

	Reservation findByNumber(int number);

	List<Reservation> findByShowShowId(Long showId);
	
	@SuppressWarnings("unchecked")
	Reservation save(Reservation reservation);

}