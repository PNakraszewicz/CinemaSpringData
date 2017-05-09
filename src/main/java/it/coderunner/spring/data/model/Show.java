package it.coderunner.spring.data.model;

import java.io.Serializable;
import java.util.Date;
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
public class Show implements Serializable {

	private static final long serialVersionUID = -4372009034470706010L;

	@Id
	@GeneratedValue
	@Column(name = "show_id")
	private Long showId;

	@ManyToOne
	@JoinColumn(name = "movie_Id", nullable = false)
	private Movie movie;

	@ManyToOne
	@JoinColumn(name = "room_Id", nullable = false)
	private Room room;

	@OneToMany(mappedBy = "show", fetch=FetchType.EAGER)
	private Set<Reservation> reservations;

	@Column(nullable = false)
	private Date date;

	public Show(Movie movie, Room room, Date date) {
		this.movie = movie;
		this.date = date;
		this.room = room;
	}

}
