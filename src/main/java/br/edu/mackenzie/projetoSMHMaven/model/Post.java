package br.edu.mackenzie.projetoSMHMaven.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import javax.persistence.*;

@Entity
public class Post {
	@Id
	@GeneratedValue
	private Long id;

	@Lob
	private String content;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dateOfCreation;

	@ManyToOne
	private Admin owner;

	@OneToMany
	private Collection<Comentario> comentarios = new ArrayList<Comentario>();

	// g&s

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Calendar getDateOfCreation() {
		return dateOfCreation;
	}

	public void setDateOfCreation(Calendar dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}

	public Admin getOwner() {
		return owner;
	}

	public void setOwner(Admin owner) {
		this.owner = owner;
	}

	public Collection<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(Collection<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

}
