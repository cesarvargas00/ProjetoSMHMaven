package br.edu.mackenzie.projetoSMHMaven.model;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import br.edu.mackenzie.projetoSMHMaven.util.Util;

@Entity
public class AndroidSession {
	
	@Id
	@GeneratedValue
	private Long id;

	@Column(length = 32)
	private String authKey ;
	
	@ManyToOne
	private Usuario user ;
	
	private Calendar expiration ;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the authKey
	 */
	public String getAuthKey() {
		return authKey;
	}

	/**
	 * @param authKey the authKey to set
	 */
	public void setAuthKey(String authKey) {
		this.authKey = authKey;
	}

	/**
	 * @return the user
	 */
	public Usuario getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(Usuario user) {
		this.user = user;
	}
	
	public void ajustExpiration() {
		this.expiration = Calendar.getInstance() ;
		this.expiration.add( Calendar.HOUR , 1 ) ;
	}
	
	public void generateKey() {
		if ( this.user != null ) {
			Date date = new Date() ;
			Random rnd = new Random() ;
			String seed = this.user.getEmail() + this.user.getId() + this.user.getPassword() + date.getTime() + rnd.nextInt( 100000 ) ;
			this.authKey = Util.MD5(seed) ;
		}
	}

}
