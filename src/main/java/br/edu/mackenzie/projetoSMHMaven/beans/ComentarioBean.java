package br.edu.mackenzie.projetoSMHMaven.beans;

import java.io.IOException;
import java.util.Calendar;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import br.edu.mackenzie.projetoSMHMaven.model.Comentario;
import br.edu.mackenzie.projetoSMHMaven.model.Post;
import br.edu.mackenzie.projetoSMHMaven.repositorios.ComentarioRepositorio;
import br.edu.mackenzie.projetoSMHMaven.repositorios.PostRepositorio;
import br.edu.mackenzie.projetoSMHMaven.util.SessaoUsuario;

@ManagedBean
public class ComentarioBean {

	private Long postId;

	private String comment;

	public String fazComentario() {
		PostRepositorio postRepo = new PostRepositorio();
		ComentarioRepositorio commRepo = new ComentarioRepositorio();

		Post post = postRepo.getById(this.postId);
		Comentario comentario = new Comentario();

		if (post == null) {
			return "index";
		}
		comentario.setPost(post);

		if (!SessaoUsuario.getInstance().isLogged()) {
			return "login";
		}
		comentario.setOwner(SessaoUsuario.getInstance().getUser());
		comentario.setComentario(this.comment);
		comentario.setDateOfCreation(Calendar.getInstance());

		commRepo.persistir(comentario);

		this.comment = "";
		return "index";
	}

	/**
	 * @return the postId
	 */
	public Long getPostId() {
		return postId;
	}

	/**
	 * @param postId
	 *            the postId to set
	 */
	public void setPostId(Long postId) {
		this.postId = postId;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment
	 *            the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
}
