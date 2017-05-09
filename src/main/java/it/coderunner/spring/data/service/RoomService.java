package it.coderunner.spring.data.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.coderunner.spring.data.model.Room;

public interface RoomService extends Serializable {
	
	Page<Room> findAll(Pageable pageable);
	Room findByNumber(String number);
	List<Room> findFirst5ByCapacity(int capacity);

	Room save(Room room);
}
