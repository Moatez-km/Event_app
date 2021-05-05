package de.tekup.ex.models;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Lob;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Activite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name",length = 50,nullable = false)
	private String name;
	@Column(name = "description",length = 50,nullable = false)
	private String description;
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String imagecover;
	@Column(name = "type",length = 50,nullable = false)
	private String type;
	
	private String date;
	@ManyToOne
	User user;
	@OneToMany(mappedBy = "activite")
	List<Comment>comment;
}
