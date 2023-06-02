package br.edu.ifsp.spo.lp2a4.spring.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pessoa {
	
	private List<Results> results;
	
	
	public List<Results> getResults() {
		return results;
	}


	public void setResults(List<Results> results) {
		this.results = results;
	}

	@Override
	  public String toString() {
	    return "Results: " + results;
	  }
}
