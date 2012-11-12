package br.edu.mackenzie.projetoSMHMaven.Android;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Iterator ;

import br.edu.mackenzie.projetoSMHMaven.json.JSONArray;
import br.edu.mackenzie.projetoSMHMaven.json.JSONException;
import br.edu.mackenzie.projetoSMHMaven.json.JSONObject;
import br.edu.mackenzie.projetoSMHMaven.model.AndroidSession;
import br.edu.mackenzie.projetoSMHMaven.model.Comentario;
import br.edu.mackenzie.projetoSMHMaven.model.Post;
import br.edu.mackenzie.projetoSMHMaven.repositorios.AndroidSessionRepositorio;
import br.edu.mackenzie.projetoSMHMaven.repositorios.PostRepositorio;
import br.edu.mackenzie.projetoSMHMaven.util.Util;

/**
 * Servlet implementation class BlogIndex
 */
public class BlogIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BlogIndex() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		response.setContentType( "application/json; charset=UTF-8" ) ;
				
		PostRepositorio repo = new PostRepositorio( true ) ;
		List<Post> posts = repo.getAllPosts() ;
		Iterator<Post> postsIt = posts.iterator() ;
		
		JSONObject jsObject = new JSONObject() ;
		JSONArray jsComments ;
		JSONObject jsonObj ;
		
		try {
			jsObject.put( "num_results" , posts.size() ) ;
			JSONArray postsJsonArray = new JSONArray() ;

			Post post ;
			
			while ( postsIt.hasNext() ) {
				post = postsIt.next() ;
				
				jsonObj = new JSONObject() ;
				jsonObj.put( "post_id" , post.getId() ) ;
				jsonObj.put( "title" , post.getTitle() ) ;
				jsonObj.put( "content" , post.getContent() ) ;
				jsonObj.put( "author" , post.getOwner().getFullName() ) ;
				
				// Cadastrando os Comentários
				jsComments = this.getComments(post) ;
				jsonObj.put( "comments" , jsComments ) ;
				jsonObj.put( "num_of_comments" , jsComments.length() ) ;
				
				postsJsonArray.put( jsonObj ) ;
			}
			
			jsObject.put( "contents" , postsJsonArray ) ;
			
			out.print( jsObject ) ;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private JSONArray getComments( Post post ) throws JSONException {
		JSONArray jsComments = new JSONArray() ;
		JSONObject jsCommentObj ;
		Iterator<Comentario> commentsIt = post.getComentarios().iterator() ;
		Comentario comment ;
		
		while ( commentsIt.hasNext() ) {
			comment = commentsIt.next() ;
			jsCommentObj = new JSONObject() ;
			jsCommentObj.put( "comment" , comment.getComentario() ) ;
			jsCommentObj.put( "author" , comment.getOwner().getFullName() ) ;
			jsCommentObj.put( "time" , Util.formmatCallendar( comment.getDateOfCreation() ) ) ;
			jsComments.put( jsCommentObj ) ;
		}
		
		return jsComments ;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
