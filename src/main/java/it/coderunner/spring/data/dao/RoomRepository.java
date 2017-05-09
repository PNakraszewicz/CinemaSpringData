package it.coderunner.spring.data.dao;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import it.coderunner.spring.data.model.Room;

public interface RoomRepository extends CrudRepository<Room, Long>{
	
	Page<Room> findAll(Pageable pageable);
	Room findByNumber(String number);
	List<Room> findFirst5ByCapacity(int capacity);

	@SuppressWarnings("unchecked")
	Room save(Room room);

}