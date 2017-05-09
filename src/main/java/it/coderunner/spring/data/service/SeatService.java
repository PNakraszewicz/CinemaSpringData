package it.coderunner.spring.data.service;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.coderunner.spring.data.model.Seat;

public interface SeatService extends Serializable {
		Page<Seat> findAll(Pageable pageable);

		Page<Seat> findByRoomNumber(int number, Pageable pageable);
		
		Page<Seat> findByRoomShowsShowId(Long showId, Pageable pageable);

		Seat save(Seat Seat);
}
