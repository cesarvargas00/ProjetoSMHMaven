package br.edu.mackenzie.projetoSMHMaven.beans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import br.edu.mackenzie.projetoSMHMaven.model.Post;
import br.edu.mackenzie.projetoSMHMaven.repositorios.PostRepositorio;

@ManagedBean
public class PostBean {
	
	private List<Post> posts ;
	
	public PostBean() {
		PostRepositorio repo = new PostRepositorio() ;
		this.posts = repo.getAllPosts() ;
	}

	/**
	 * @return the posts
	 */
	public List<Post> getPosts() {
		return posts;
	}

	/**
	 * @param posts the posts to set
	 */
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

}
