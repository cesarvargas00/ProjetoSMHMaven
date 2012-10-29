package br.edu.mackenzie.projetoSMHMaven.model;

import javax.persistence.Persistence;

public class TesteBanco {

	public TesteBanco() {
		
	}

	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("bancoSMH");
	}

}
