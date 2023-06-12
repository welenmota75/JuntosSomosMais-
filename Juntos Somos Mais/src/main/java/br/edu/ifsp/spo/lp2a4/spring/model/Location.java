package br.edu.ifsp.spo.lp2a4.spring.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import br.edu.ifsp.spo.lp2a4.spring.jsonDeserializer.JsonObjectListDeserializer;

@Entity
public class Location {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "postcode")
	private String postcode;
	
	@Column(name = "region")
	private String region;

	@JsonDeserialize(using = JsonObjectListDeserializer.class)
	@OneToMany(mappedBy="location", cascade = CascadeType.PERSIST)
	private List<Coordinates> coordinates;
	
	@JsonDeserialize(using = JsonObjectListDeserializer.class)
	@OneToMany(mappedBy="location", cascade = CascadeType.PERSIST)
	private List<Timezone> timezones;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
    private Results results;
	
	
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
	
	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
	public Results getResults() {
		return results;
	}

	public void setResults(Results results) {
		this.results = results;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		if (state.equals("amazonas") || state.equals("roraima")  || state.equals("amapá") || state.equals("pará") ||
		    state.equals("tocantins") || state.equals("rondônia") || state.equals("acre")) {
			region = "norte";
		} else if (state.equals("maranhão")   || state.equals("piauí")   || state.equals("ceará")   || state.equals("rio grande do norte") ||
			       state.equals("pernambuco") || state.equals("paraíba") || state.equals("sergipe") || state.equals("alagoas") ||
			       state.equals("bahia")) {
			region = "nordeste";
		} else if (state.equals("mato grosso") || state.equals("mato grosso do sul") || state.equals("goiás") || 
				   state.equals("distrito federal")) {
			region = "centro-oeste";
		} else if (state.equals("são paulo") || state.equals("rio de janeiro") || state.equals("espírito santo") || 
				    state.equals("minas gerais")) {
			region = "sudeste";
		} else if (state.equals("paraná") || state.equals("rio grande do sul") || state.equals("santa catarina")) {
			region = "sul";
		}
		this.state = state;
	}

	public List<Coordinates> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(List<Coordinates> coordinates) {
		this.coordinates = coordinates;
	}

	public List<Timezone> getTimezones() {
		return timezones;
	}

	public void setTimezones(List<Timezone> timezones) {
		this.timezones = timezones;
	}
	
	@Override
	  public String toString() {
	    return "street: " + street + "city: " + city + "state: " + state + "coordinates: " + coordinates + 
	    	   "timezone: " + timezones + "postcode: " + postcode; // "region: " + region;
	}
}
