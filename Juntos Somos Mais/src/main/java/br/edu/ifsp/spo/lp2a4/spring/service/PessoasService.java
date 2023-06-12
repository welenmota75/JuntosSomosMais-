package br.edu.ifsp.spo.lp2a4.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifsp.spo.lp2a4.spring.model.Results;
import br.edu.ifsp.spo.lp2a4.spring.model.Location;
import br.edu.ifsp.spo.lp2a4.spring.model.Name;
import br.edu.ifsp.spo.lp2a4.spring.model.Picture;
import br.edu.ifsp.spo.lp2a4.spring.repository.LocationRepository;
import br.edu.ifsp.spo.lp2a4.spring.repository.NameRepository;
import br.edu.ifsp.spo.lp2a4.spring.repository.PessoaRepository;
import br.edu.ifsp.spo.lp2a4.spring.repository.PictureRepository;

@Service
public class PessoasService {

	@Autowired
	private PessoaRepository repository;

	@Autowired
	private PictureRepository repository2;
	
	@Autowired
	private NameRepository repository3;
	
	@Autowired
	private LocationRepository repository4;
	
	//Pessoa
	public List<Results> listAll() {

		List<Results> results = new ArrayList<>();
		repository.findAll().forEach(results::add);		
		return results;
	}

	public void addResult(Results results) {
		repository.save(results);
	}
	
	public Results buscaId(int Id) {
		return repository.findById(Id);
	}
	
	//Picture
	public List<Picture> listAllp() {

		List<Picture> picture = new ArrayList<>();
		repository2.findAll().forEach(picture::add);		
		return picture;
	}

	public void addResult(Picture picture) {
		repository2.save(picture);
	}
	
	//Name
	public List<Name> listAlln() {

		List<Name> name = new ArrayList<>();
		repository3.findAll().forEach(name::add);		
		return name;
	}

	public void addResult(Name name) {
		repository3.save(name);
	}
	
	//Location
	public List<Location> listAlll() {

		List<Location> location = new ArrayList<>();
		repository4.findAll().forEach(location::add);		
		return location;
	}

	public void addResult(Location location) {
		repository4.save(location);
	}
}
