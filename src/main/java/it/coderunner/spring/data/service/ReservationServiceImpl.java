package it.coderunner.spring.data.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import it.coderunner.spring.data.dao.ReservationRepository;
import it.coderunner.spring.data.model.Reservation;

@Service
public class ReservationServiceImpl implements ReservationService {
	private static final long serialVersionUID = -5212497294563141450L;
	
	@Resource
	private ReservationRepository ReservationRepository;
	
	@Override
	public Page<Reservation> findAll(Pageable pageable) {
		return ReservationRepository.findAll(pageable);
	}

	@Override
	public Page<Reservation> findByEmailContainingAndNameContainingAllIgnoringCase(String email, String name,
			Pageable pageable) {
		return ReservationRepository.findByEmailContainingAndNameContainingAllIgnoringCase(email, name, pageable);
	}

	@Override
	public Reservation findByNumber(int number) {
		return ReservationRepository.findByNumber(number);
	}

	@Override
	public List<Reservation> findByShowShowId(Long showId) {
		return ReservationRepository.findByShowShowId(showId);
	}

	@Override
	public Reservation save(Reservation reservation) {
		return ReservationRepository.save(reservation);
	}
	
}
