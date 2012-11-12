package br.edu.mackenzie.projetoSMHMaven.Android;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.mackenzie.projetoSMHMaven.exception.UserNotFoundException;
import br.edu.mackenzie.projetoSMHMaven.json.JSONException;
import br.edu.mackenzie.projetoSMHMaven.json.JSONObject;
import br.edu.mackenzie.projetoSMHMaven.model.AndroidSession;
import br.edu.mackenzie.projetoSMHMaven.model.Comentario;
import br.edu.mackenzie.projetoSMHMaven.model.Post;
import br.edu.mackenzie.projetoSMHMaven.model.Usuario;
import br.edu.mackenzie.projetoSMHMaven.repositorios.AndroidSessionRepositorio;
import br.edu.mackenzie.projetoSMHMaven.repositorios.ComentarioRepositorio;
import br.edu.mackenzie.projetoSMHMaven.repositorios.PostRepositorio;
import br.edu.mackenzie.projetoSMHMaven.repositorios.UsuarioRepositorio;

/**
 * Servlet implementation class Comentario
 */
public class ComentarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComentarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String authKey = request.getParameter( "auth_key" ) ;
		
		PrintWriter out = response.getWriter() ;
		JSONObject jsResponse = new JSONObject() ;
		
		try {
			try {
				Usuario usuario = this.checkAuthKey(authKey) ;
				
				String comment = request.getParameter( "comment" ) ;
				Comentario comentario = new Comentario() ;
				
				comentario.setComentario(comment) ;
				comentario.setOwner(usuario) ;
				comentario.setDateOfCreation(Calendar.getInstance()) ;
				
				Long postId = Long.decode( request.getParameter( "post_id" ) ) ;
				PostRepositorio repo = new PostRepositorio( true ) ;
				Post post = repo.getById( postId ) ;
				
				comentario.setPost(post) ;
				
				ComentarioRepositorio repoComment = new ComentarioRepositorio(true) ;
				repoComment.begin() ;
				repoComment.persistir(comentario) ;
				repoComment.commit() ;
				
				jsResponse.put( "status" , "commented" ) ;
				jsResponse.put( "message" , "Comentário enviado com sucesso" ) ;
			} catch (UserNotFoundException e) {
				jsResponse.put( "status" , "not_logged" ) ;
				jsResponse.put( "message" , "Usuário não logado" ) ;
				e.printStackTrace();
			}
		} catch (JSONException e1) {

		}
		
		out.print( jsResponse.toString() ) ;
	}
	
	private Usuario checkAuthKey( String authKey ) throws UserNotFoundException {
		AndroidSessionRepositorio repo = new AndroidSessionRepositorio( true ) ;
	
		Usuario usuario = repo.getByAuthKey( authKey ) ;
		return usuario ;
	}

}
