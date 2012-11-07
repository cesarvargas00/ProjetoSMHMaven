package br.edu.mackenzie.projetoSMHMaven.repositorios;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class Repositorio {
	
	private EntityManager manager ;
	
	public Repositorio() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory( "bancoSMH" ) ;
		this.manager = factory.createEntityManager() ;
	}

	/**
	 * @return the manager
	 */
	protected EntityManager getManager() {
		return manager;
	}

	/**
	 * @param manager the manager to set
	 */
	protected void setManager(EntityManager manager) {
		this.manager = manager;
	}

}
