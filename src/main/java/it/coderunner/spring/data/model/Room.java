package it.coderunner.spring.data.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Room implements Serializable {

	private static final long serialVersionUID = -4372009034470706010L;

	@Id
	@GeneratedValue
	@Column(name = "room_id")
	private Long roomId;

	@Column(nullable = false)
	private String number;

	@Column(name = "num_of_rows", nullable = false)
	private int numOfRows;

	@Column(nullable = false)
	private int capacity;

	// HashSet????????????????
	@OneToMany(mappedBy = "room", fetch=FetchType.EAGER)
	private Set<Show> shows = new HashSet<>();

	// new HashSet w Room czy Seat, czy w obu??
	@OneToMany(mappedBy = "room", fetch=FetchType.EAGER)
	private Set<Seat> seats = new HashSet<>();

	public Room(String number, int numOfRows, int capacity) {
		this.number = number;
		this.numOfRows = numOfRows;
		this.capacity = capacity;

	}

}
