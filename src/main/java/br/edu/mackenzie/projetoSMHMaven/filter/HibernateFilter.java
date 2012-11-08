package br.edu.mackenzie.projetoSMHMaven.filter;

import java.io.IOException;

import javax.persistence.EntityManager ;
import javax.persistence.EntityManagerFactory ;
import javax.persistence.Persistence ;
import javax.servlet.Filter ;
import javax.servlet.FilterChain ;
import javax.servlet.FilterConfig ;
import javax.servlet.ServletException ;
import javax.servlet.ServletRequest ;
import javax.servlet.ServletResponse ;

/**
 * Filtro de conexão do Hibernate. Elimina a necessidade de criar um entity
 * manager todas as vezes.
 */
public class HibernateFilter implements Filter {
	
	public static final String ENTITY_MANAGER_NAME = "EntityManager" ;
	
	public static final String PERSISTENCE_UNIT_NAME = "bancoSMH" ;
	
	private EntityManagerFactory factory;

	public void destroy() {
		this.factory.close();
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		EntityManager manager = this.factory.createEntityManager() ;
		
		request.setAttribute( ENTITY_MANAGER_NAME , manager ) ;
		manager.getTransaction().begin() ;
		
		chain.doFilter(request, response);
		
		try {
			manager.getTransaction().commit();
		}
		catch ( Exception e ) {
			manager.getTransaction().rollback();
		}
		finally {
			manager.close();
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		this.factory = Persistence.createEntityManagerFactory( PERSISTENCE_UNIT_NAME ) ;
	}

}
