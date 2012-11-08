package br.edu.mackenzie.projetoSMHMaven.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Post {
	@Id
	@GeneratedValue
	private Long id;
	
	private String title ;

	@Lob
	private String content;	

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dateOfCreation;

	@ManyToOne
	private Usuario owner;

	@OneToMany( mappedBy = "post" )
	private Set<Comentario> comentarios ;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
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

	public Usuario getOwner() {
		return owner;
	}

	public void setOwner(Usuario owner) {
		this.owner = owner;
	}

	public Set<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios( Set<Comentario> comentarios ) {
		this.comentarios = comentarios;
	}

}
