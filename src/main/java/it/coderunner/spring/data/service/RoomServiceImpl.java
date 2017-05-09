package it.coderunner.spring.data.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.coderunner.spring.data.dao.RoomRepository;
import it.coderunner.spring.data.model.Room;

public class RoomServiceImpl implements RoomService {

	private static final long serialVersionUID = 1L;
	@Resource 
	private RoomRepository RoomRepository;
	
	@Override
	public Page<Room> findAll(Pageable pageable) {
		return RoomRepository.findAll(pageable);
	}

	@Override
	public Room findByNumber(String number) {
		return RoomRepository.findByNumber(number);
	}

	@Override
	public List<Room> findFirst5ByCapacity(int capacity) {
		return RoomRepository.findFirst5ByCapacity(capacity);
	}

	@Override
	public Room save(Room room) {
		return RoomRepository.save(room);
	}

}
