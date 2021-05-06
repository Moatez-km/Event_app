package de.tekup.ex.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "message",length = 255,nullable = false)
	private String message;
	@Column(name = "time",length = 255,nullable = false)
	private String time;
	@ManyToOne
	private User user;
	@ManyToOne
	private Activite activite;
}
