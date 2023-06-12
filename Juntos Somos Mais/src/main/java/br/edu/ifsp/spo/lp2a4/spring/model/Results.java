package br.edu.ifsp.spo.lp2a4.spring.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import br.edu.ifsp.spo.lp2a4.spring.jsonDeserializer.JsonObjectListDeserializer;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "pessoas")
public class Results {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Pessoas_id")
	private Integer id;

	@Column(name = "gender")
	private String gender;

	@Column(name = "email")
	private String email;

	@Column(name = "phone")
	private String phone;

	@Column(name = "cell")
	private String cell;

	@Column(name = "nationality")
	private String nationality = "BR";
	
	@JsonDeserialize(using = JsonObjectListDeserializer.class)
	@OneToMany(mappedBy="results", cascade = CascadeType.PERSIST)
	private List<Name> name;

	@JsonDeserialize(using = JsonObjectListDeserializer.class)
	@OneToMany(mappedBy="results", cascade = CascadeType.PERSIST)
	private List<Location> location;

	@JsonDeserialize(using = JsonObjectListDeserializer.class)
	@OneToMany(mappedBy="results", cascade = CascadeType.PERSIST)
	private List<Dob> dob;

	@JsonDeserialize(using = JsonObjectListDeserializer.class)
	@OneToMany(mappedBy="results", cascade = CascadeType.PERSIST)
	private List<Registered> registered;	

	@JsonDeserialize(using = JsonObjectListDeserializer.class)
	@OneToMany(mappedBy="results" , cascade = CascadeType.PERSIST)
	private List<Picture> picture;

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public List<Picture> getPicture() {
		return picture;
	}

	public void setPicture(List<Picture> picture) {
		this.picture = picture;
	}


	public List<Registered> getRegistered() {
		return registered;
	}

	public void setRegistered(List<Registered> registered) {
		this.registered = registered;
	}

	public List<Dob> getDob() {
		return dob;
	}

	public void setDob(List<Dob> dob) {
		this.dob = dob;
	}

	public List<Location> getLocation() {
		return location;
	}

	public void setLocation(List<Location> location) {
		this.location = location;
	}

	public List<Name> getName() {
		return name;
	}

	public void setName(List<Name> name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		if (gender.equals("female")) {
			gender = "f";
		} else if (gender.equals("male")){
			gender = "m";
		} 
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		if (phone.length() == 14) {
			String phone1 = phone.toString();
			String phone2 = phone1.replaceAll("-", "");
			String phone3 = phone2.replaceAll("\\(", "");
			String phone4 = phone3.replaceAll("\\)", "");
			String phone5 = phone4.replaceAll("\\s+", "");
			String phone6 = ("+55" + phone5);
			phone = phone6;	

			this.phone = phone;

		} else if (phone.length() < 14) {
			this.phone = phone;
		}		
	}

	public String getCell() {
		return cell;
	}

	public void setCell(String cell) {
		if (cell.length() == 14) {
			String cell1 = cell.toString();
			String cell2 = cell1.replaceAll("-", "");
			String cell3 = cell2.replaceAll("\\(", "");
			String cell4 = cell3.replaceAll("\\)", "");
			String cell5 = cell4.replaceAll("\\s+", "");
			String FormattedCell = ("+55" + cell5);
			cell = FormattedCell;

			this.cell = cell;

		} else if (cell.length() < 14) {
			this.cell = cell;
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "gender: " + gender + "email: " + email + "names: " + name +  "email: " + email +
				"phone: " + phone + "cell" + cell + "nationality: " + nationality ;
	}
}
