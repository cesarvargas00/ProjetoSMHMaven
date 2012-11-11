package br.edu.mackenzie.projetoSMHMaven.repositorios;

import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;

import br.edu.mackenzie.projetoSMHMaven.filter.HibernateFilter;

public abstract class Repositorio {
	
	private EntityManager manager ;
	
	public Repositorio() {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest() ;
		this.manager = (EntityManager) request.getAttribute( HibernateFilter.ENTITY_MANAGER_NAME ) ;
	}
	
	public Repositorio( Boolean useFactory ) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory( HibernateFilter.PERSISTENCE_UNIT_NAME ) ;
		this.manager = factory.createEntityManager() ;
	}
	
	public void begin() {
		this.manager.getTransaction().begin() ;
	}
	
	public void commit() {
		this.manager.getTransaction().commit() ;
	}

	/**
	 * @return the manager
	 */
	protected EntityManager getManager() {
		return manager;
	}
	
	public Object merge(Object o) {
		this.manager.merge(o);
		return o;
	}
}
