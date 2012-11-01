package br.edu.mackenzie.projetoSMHMaven.filter;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Filtro de conexão do Hibernate. Elimina a necessidade de criar um entity
 * manager todas as vezes.
 */
@WebFilter(servletNames = { "Faces Servlet" })
public class HibernateFilter implements Filter {
	private EntityManagerFactory factory;

	public HibernateFilter() {
	}

	public void destroy() {
		this.factory.close();
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// ENTRADA
		EntityManager manager = this.factory.createEntityManager();
		request.setAttribute("EntityManager", manager);
		manager.getTransaction().begin();
		// ENTRADA
		chain.doFilter(request, response);
		// SAIDA
		try {
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
		// SAIDA

	}

	public void init(FilterConfig fConfig) throws ServletException {
		this.factory = Persistence.createEntityManagerFactory("bancoSMH");
	}

}
