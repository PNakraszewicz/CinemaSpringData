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
public class Movie implements Serializable {

	private static final long serialVersionUID = -4372009034470706010L;

	@Id
	@GeneratedValue
	@Column(name = "movie_id")
	private Long movieId;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private String type;

	@OneToMany(mappedBy = "movie", fetch=FetchType.EAGER)
	private Set<Show> shows = new HashSet<>();

	public Movie(String title, String type) {
		this.title = title;
		this.type = type;
	}

}
