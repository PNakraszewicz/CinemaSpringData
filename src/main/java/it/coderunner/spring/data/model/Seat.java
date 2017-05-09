package it.coderunner.spring.data.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Seat implements Serializable {

	private static final long serialVersionUID = -4372009034470706010L;

	@Id
	@GeneratedValue
	@Column(name = "seat_id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "room_Id", nullable = false)
	private Room room;

	@ManyToOne
	@JoinColumn(name = "reservation_Id", nullable = false)
	private Reservation reservation;

	@Column(name = "row_Number", nullable = false)
	private int rowNumber;

	@Column(nullable = false)
	private int number;

	public Seat(int number, int rowNumber, Room room) {
		this.number = number;
		this.rowNumber = rowNumber;
		this.room = room;
	}

}
