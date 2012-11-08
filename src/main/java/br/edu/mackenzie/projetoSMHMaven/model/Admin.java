package br.edu.mackenzie.projetoSMHMaven.model;

import java.util.Set;
import javax.persistence.*;

@Entity
public class Admin extends Usuario {

	public Admin() {
		super() ;
	}

	@OneToMany( mappedBy = "owner" )
	private Set<Post> posts ;

	public Set<Post> getPosts() {
		return posts;
	}
	
	public boolean isAdmin() {
		return true ;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}
	
}
