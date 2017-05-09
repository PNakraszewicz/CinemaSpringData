package it.coderunner.spring.data.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import it.coderunner.spring.data.model.Seat;

public interface SeatRepository extends CrudRepository<Seat, Long>{
	
//
	Page<Seat> findAll(Pageable pageable);
//w nazwie metody sa nazwy pól, model i title musza byc takie jak w db
	Page<Seat> findByRoomNumber(int number, Pageable pageable);
	
	Page<Seat> findByRoomShowsShowId(Long showId, Pageable pageable);
	
	@SuppressWarnings("unchecked")
	Seat save(Seat Seat);

}