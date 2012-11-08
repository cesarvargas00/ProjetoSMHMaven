package br.edu.mackenzie.projetoSMHMaven.repositorios;

import java.util.List;

import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

import br.edu.mackenzie.projetoSMHMaven.model.Post;
import br.edu.mackenzie.projetoSMHMaven.model.Usuario;

public class PostRepositorio extends Repositorio {
	
	public void persistir( Post post ) {
		EntityManager manager = this.getManager() ;
		
		this.getManager().persist( post ) ;
	}

	public List<Post> getAllPosts() {
		EntityManager manager = this.getManager() ;
		List<Post> posts = null ;
		
		Query query = manager.createQuery( "SELECT p FROM Post p" ) ;
		posts = query.getResultList() ;

		return posts ;
	}
	
}
