package br.edu.mackenzie.projetoSMHMaven.repositorios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.mackenzie.projetoSMHMaven.model.Post;

public class PostRepositorio extends Repositorio {
	
	public PostRepositorio(boolean b) {
		super(b) ;
	}

	public void persistir( Post post ) {
		
		this.getManager().persist( post ) ;
	}

	public List<Post> getAllPosts() {
		EntityManager manager = this.getManager() ;
		List<Post> posts = null ;
		
		Query query = manager.createQuery( "SELECT p FROM Post p order by p.id desc" ) ;
		posts = query.getResultList() ;

		return posts ;
	}
	
	public Post getById( Long id ) {
		EntityManager manager = this.getManager() ;
		Post post = manager.getReference( Post.class , id ) ;
		return post ;
	}
	
	
	
}
