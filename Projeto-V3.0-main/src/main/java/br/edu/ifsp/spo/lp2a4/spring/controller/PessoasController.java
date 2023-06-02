package br.edu.ifsp.spo.lp2a4.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifsp.spo.lp2a4.spring.model.Results;
import br.edu.ifsp.spo.lp2a4.spring.model.Location;
import br.edu.ifsp.spo.lp2a4.spring.model.Name;
import br.edu.ifsp.spo.lp2a4.spring.model.Picture;
import br.edu.ifsp.spo.lp2a4.spring.service.PessoasService;

@Controller
public class PessoasController {

	@Autowired
	private PessoasService service;
	
	@RequestMapping("/results")
	public ModelAndView home() {
		ModelAndView ModelAndView = new ModelAndView("Lista-Pessoas-HTML");

		List<Results> listResults = service.listAll();
		List<Picture> listpicture = service.listAllp();
		List<Name> listname = service.listAlln();
		List<Location> listlocation = service.listAlll();

		ModelAndView.addObject("listResults", listResults);
		ModelAndView.addObject("listlocation", listlocation);
		ModelAndView.addObject("listpicture", listpicture);
		ModelAndView.addObject("listname", listname);
		return ModelAndView;
	}
	
	@RequestMapping("/results/{id}")
	public @ResponseBody ModelAndView filtrar(@PathVariable Integer id) {
		ModelAndView ModelAndView = new ModelAndView("Pessoas-Descricao-HTML");

		Results listResultsId = service.buscaId(id);

		ModelAndView.addObject("listResultsId", listResultsId);

		return ModelAndView;	
	}
	
}
