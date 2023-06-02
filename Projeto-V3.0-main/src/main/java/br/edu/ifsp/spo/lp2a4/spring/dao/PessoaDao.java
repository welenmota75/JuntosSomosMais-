package br.edu.ifsp.spo.lp2a4.spring.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.ifsp.spo.lp2a4.spring.model.Results;

public class PessoaDao {

	//Adicionando Contatos
	public void adiciona(Results result) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pessoas");

		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();     
		manager.persist(result);
		manager.getTransaction().commit();

		manager.close();
		factory.close();

	}
}
