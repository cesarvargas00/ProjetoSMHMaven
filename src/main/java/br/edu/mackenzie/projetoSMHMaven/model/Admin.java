package br.edu.mackenzie.projetoSMHMaven.model;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.*;

@Entity
public class Admin extends Usuario {

	public Admin() {

	}

	@OneToMany
	private Collection<Post> posts = new ArrayList<Post>();

	public Collection<Post> getPosts() {
		return posts;
	}

	public void setPosts(Collection<Post> posts) {
		this.posts = posts;
	}

}
