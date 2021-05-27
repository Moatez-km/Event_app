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
public class Reactions {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "compteur")
	private int compteur;
	@ManyToOne
	User user;
	@ManyToOne
	Activite activite;

}
