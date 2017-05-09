package it.coderunner.spring.data.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Reservation implements Serializable {

	private static final long serialVersionUID = -4372009034470706010L;

	@Id
	@GeneratedValue
	@Column(name = "reservation_id")
	private Long reservationId;

	@ManyToOne
	@JoinColumn(name = "Show_Id", nullable = false)
	private Show show;

	@Column(name = "row_Number", nullable = false)
	private int rowNumber;

	@Column(nullable = false)
	private int number;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String email;

	@OneToMany(mappedBy = "reservation", fetch=FetchType.EAGER)
	private Set<Seat> seats = new HashSet<>();

	public Reservation(int number, String name, String email, Set<Seat> seats, Show show, int rowNumber) {
		this.number = number;
		this.name = name;
		this.email = email;
		this.seats = seats;
		this.show = show;
		this.rowNumber = rowNumber;
	}

}
