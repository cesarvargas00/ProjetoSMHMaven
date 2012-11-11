package br.edu.mackenzie.projetoSMHMaven.Android;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpUtils;

import org.apache.commons.lang3.StringEscapeUtils;

import java.util.List;
import java.util.Iterator ;

import br.edu.mackenzie.projetoSMHMaven.json.JSONArray;
import br.edu.mackenzie.projetoSMHMaven.json.JSONException;
import br.edu.mackenzie.projetoSMHMaven.json.JSONObject;
import br.edu.mackenzie.projetoSMHMaven.model.Post;
import br.edu.mackenzie.projetoSMHMaven.repositorios.PostRepositorio;

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
		try {
			jsObject.put( "num_results" , posts.size() ) ;
			JSONArray postsJsonArray = new JSONArray() ;
			JSONObject jsonObj ;
			Post post ;
			
			while ( postsIt.hasNext() ) {
				post = postsIt.next() ;
				jsonObj = new JSONObject() ;
				jsonObj.put( "title" , post.getTitle() ) ;
				jsonObj.put( "content" , post.getContent() ) ;
				postsJsonArray.put( jsonObj ) ;
			}
			
			jsObject.put( "contents" , postsJsonArray ) ;
			
			out.print( jsObject ) ;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
