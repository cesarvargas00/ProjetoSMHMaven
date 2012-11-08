package br.edu.mackenzie.projetoSMHMaven.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.*;

import br.edu.mackenzie.projetoSMHMaven.util.Util;

@Entity
public class Post {
	@Id
	@GeneratedValue
	private Long id;

	private String title ;

	@Lob
	private String content;

	@Lob
	private String contentTextile ;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dateOfCreation;

	@ManyToOne
	private Usuario owner;

	@OneToMany( mappedBy = "post" )
	private List<Comentario> comentarios ;

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

	/**
	 * @return the contentTextile
	 */
	public String getContentTextile() {
		return contentTextile;
	}

	/**
	 * @param contentTextile the contentTextile to set
	 */
	public void setContentTextile(String contentTextile) {
		this.contentTextile = contentTextile;
	}

	public Calendar getDateOfCreation() {
		return dateOfCreation;
	}

	public String getDateFormmated() {
		return Util.formmatCallendar( this.dateOfCreation ) ;
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

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", content=" + content
				+ ", contentTextile=" + contentTextile + ", dateOfCreation="
				+ dateOfCreation + ", owner=" + owner + ", comentarios="
				+ comentarios + "]";
	}
	
}
