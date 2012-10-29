package br.edu.mackenzie.projetoSMHMaven.model;

import java.util.Calendar;
import javax.persistence.*;

@Entity
public class Comentario {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false, length = 150)
	private String comentario;
	
	@ManyToOne
	private Usuario owner;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dateOfCreation;

	//g&s
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Usuario getOwner() {
		return owner;
	}

	public void setOwner(Usuario owner) {
		this.owner = owner;
	}

	public Calendar getDateOfCreation() {
		return dateOfCreation;
	}

	public void setDateOfCreation(Calendar dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}
	
	
	
}
