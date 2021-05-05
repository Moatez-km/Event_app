package de.tekup.ex.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import javax.persistence.OneToMany;



import lombok.Data;

@Entity
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	 @Column(name = "nom",length = 50,nullable = false)
	private String nom;
	 @Column(name = "prenom",length = 50,nullable = false)
	private String prenom;
	 @Column(name = "email",length = 50,nullable = false)
	private String email;
	 @Column(name = "password",length = 50,nullable = false)
	private String password;
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String image;
	@OneToMany(mappedBy = "user")
	List<Activite>activite;
	
	@OneToMany(mappedBy="user")
	List<Comment>comment;
}
