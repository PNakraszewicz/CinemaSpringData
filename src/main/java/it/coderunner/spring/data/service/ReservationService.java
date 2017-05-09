package it.coderunner.spring.data.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.coderunner.spring.data.model.Reservation;

public interface ReservationService extends Serializable {
	
	Page<Reservation> findAll(Pageable pageable);

	Page<Reservation> findByEmailContainingAndNameContainingAllIgnoringCase(String email,
			String name, Pageable pageable);

	Reservation findByNumber(int number);

	List<Reservation> findByShowShowId(Long showId);

	Reservation save(Reservation reservation);
}
