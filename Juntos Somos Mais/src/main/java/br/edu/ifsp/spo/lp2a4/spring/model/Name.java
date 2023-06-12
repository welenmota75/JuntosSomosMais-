package br.edu.ifsp.spo.lp2a4.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Name {
	
	@Id
	@Column(name = "name_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer name_id;

	@Column(name = "title")
	private String title;
	
	@Column(name = "first")
	private String first;
	
	@Column(name = "last")
	private String last;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
    private Results results;
	
	public Integer getName_id() {
		return name_id;
	}
	public void setName_id(Integer name_id) {
		this.name_id = name_id;
	}
	
	public Results getResults() {
		return results;
	}
	
	public void setResults(Results results) {
		this.results = results;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	
	@Override
	  public String toString() {
	    return "title: " + title + "first: " + first + "last: " + last;
	}
	
}
