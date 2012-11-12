package br.edu.mackenzie.projetoSMHMaven.Android;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.mackenzie.projetoSMHMaven.exception.UserNotFoundException;
import br.edu.mackenzie.projetoSMHMaven.json.JSONException;
import br.edu.mackenzie.projetoSMHMaven.json.JSONObject;
import br.edu.mackenzie.projetoSMHMaven.model.AndroidSession;
import br.edu.mackenzie.projetoSMHMaven.model.Usuario;
import br.edu.mackenzie.projetoSMHMaven.repositorios.AndroidSessionRepositorio;
import br.edu.mackenzie.projetoSMHMaven.repositorios.UsuarioRepositorio;
import br.edu.mackenzie.projetoSMHMaven.util.Util;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter() ;
		out.print("Fazendo get... Tá errado.." ) ;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter( "email" ) ;
		String senha = request.getParameter( "senha" ) ;
		
		PrintWriter out = response.getWriter() ;
		UsuarioRepositorio repo = new UsuarioRepositorio( true ) ;
		JSONObject jsonResponse = new JSONObject() ;
		
		try {
			Usuario usuario = repo.login( email , Util.MD5( senha ) ) ;
			
			AndroidSession androidSession = new AndroidSession() ;
			androidSession.setUser(usuario) ;
			androidSession.ajustExpiration() ;
			androidSession.generateKey() ;
			
			AndroidSessionRepositorio repoAndSess = new AndroidSessionRepositorio( true ) ;
			repoAndSess.begin() ;
			repoAndSess.persistir(androidSession) ;
			repoAndSess.commit() ;
			
			jsonResponse.put( "status" , "logged" ) ;
			jsonResponse.put( "message" , "Bem-vindo " + usuario.getFullName() ) ;
			jsonResponse.put( "user_name" , usuario.getFullName() ) ;
			jsonResponse.put( "auth_key" , androidSession.getAuthKey() ) ;
			
		} catch (UserNotFoundException e) {
			try {
				jsonResponse.put( "status" , "not_found" ) ;
				jsonResponse.put( "message" , "Usuário não encontrado" ) ;
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			out.print( jsonResponse.toString() ) ;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		out.print( jsonResponse.toString() ) ;
	}
}
