package br.edu.ifsp.spo.lp2a4.spring.repository;

import org.springframework.data.repository.CrudRepository;

import br.edu.ifsp.spo.lp2a4.spring.model.Results;


public interface PessoaRepository extends CrudRepository<Results, Integer>{

	Results findById(int Id);
	
}
