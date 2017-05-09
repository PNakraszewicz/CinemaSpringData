package it.coderunner.spring.data.service;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.coderunner.spring.data.dao.SeatRepository;
import it.coderunner.spring.data.model.Seat;

public class SeatServiceImpl implements SeatService {

	private static final long serialVersionUID = 2233433654238693742L;

	@Resource
	private SeatRepository SeatRepository;
	
	@Override
	public Page<Seat> findAll(Pageable pageable) {
		return SeatRepository.findAll(pageable);
	}

	@Override
	public Page<Seat> findByRoomNumber(int number, Pageable pageable) {
		return SeatRepository.findByRoomNumber(number, pageable);
	}

	@Override
	public Page<Seat> findByRoomShowsShowId(Long showId, Pageable pageable) {
		return SeatRepository.findByRoomShowsShowId(showId, pageable);
	}

	@Override
	public Seat save(Seat seat) {
		return SeatRepository.save(seat);
	}

}
