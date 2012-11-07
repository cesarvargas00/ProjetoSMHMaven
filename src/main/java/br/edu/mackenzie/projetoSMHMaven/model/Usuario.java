package br.edu.mackenzie.projetoSMHMaven.model;

import java.util.ArrayList;
import java.util.Set;

import javax.persistence.*;
//TODO Como agente vai implementar o avatar ( profile picture )? Agente vai fazer um upload direto pro banco?
//Como faz isso?

import br.edu.mackenzie.projetoSMHMaven.util.Util;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Usuario {
	@Id
	@GeneratedValue
	private Long id;

	@Column(length = 50, nullable = false, unique = true)
	private String email;

	@Column(length = 32, nullable = false)
	private String password;

	@Column(length = 30, nullable = false)
	private String firstName;

	@Column(length = 30, nullable = false)
	private String lastName;

	private String avatar;

	@OneToMany( mappedBy = "owner" )
	private Set<Comentario> comentarios ;

	// g&s

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setPasswordMD5(String password) {
		this.password = Util.MD5( password ) ;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Set<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(Set<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	
	public String toString() {
		return this.firstName + " - " + this.email ;
	}
	
}
