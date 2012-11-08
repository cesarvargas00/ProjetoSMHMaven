package br.edu.mackenzie.projetoSMHMaven.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.mackenzie.projetoSMHMaven.model.Usuario;
import br.edu.mackenzie.projetoSMHMaven.util.SessaoUsuario;

public class AdminAccess implements Filter {
	
	private static final String LOGIN_URL = "/ProjetoSMHMaven/login.xhtml" ;

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		if ( ! SessaoUsuario.getInstance( request ).isLogged() ) {
			res.sendRedirect( LOGIN_URL ) ;
		}
		else {
			Usuario usuario = SessaoUsuario.getInstance( request ).getUser() ;
			
			if ( ! usuario.isAdmin() ) {
				res.sendRedirect( LOGIN_URL ) ;
			}
			else {
				chain.doFilter( request , response ) ;				
			}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
