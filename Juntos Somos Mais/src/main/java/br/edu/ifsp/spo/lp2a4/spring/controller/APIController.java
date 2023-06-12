package br.edu.ifsp.spo.lp2a4.spring.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;


import br.edu.ifsp.spo.lp2a4.spring.model.Results;
import br.edu.ifsp.spo.lp2a4.spring.repository.PessoaRepository;

@RestController
public class APIController {

	@Autowired
	private PessoaRepository repository;

	@GetMapping("API")
	public List<Results> listaResultados () {
		return (List<Results>) repository.findAll();
	}
	
}
