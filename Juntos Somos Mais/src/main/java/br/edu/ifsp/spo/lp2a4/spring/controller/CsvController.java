package br.edu.ifsp.spo.lp2a4.spring.controller;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Controller;

import br.edu.ifsp.spo.lp2a4.spring.dao.PessoaDao;
import br.edu.ifsp.spo.lp2a4.spring.model.Coordinates;
import br.edu.ifsp.spo.lp2a4.spring.model.Dob;
import br.edu.ifsp.spo.lp2a4.spring.model.Location;
import br.edu.ifsp.spo.lp2a4.spring.model.Name;
import br.edu.ifsp.spo.lp2a4.spring.model.Picture;
import br.edu.ifsp.spo.lp2a4.spring.model.Registered;
import br.edu.ifsp.spo.lp2a4.spring.model.Results;
import br.edu.ifsp.spo.lp2a4.spring.model.Timezone;

@Controller
public class CsvController {

	private static Scanner input;
	private static Scanner input_name;
	private static Scanner input_dob;
	private static Scanner input_registered;
	private static Scanner input_picture;
	private static Scanner input_location;
	private static Scanner input_coordinates;
	private static Scanner input_timezone;
	
	private static ArrayList<Results> dao = new ArrayList<>();

	public ArrayList<Results> loader(String file) {

		try {
			input = new Scanner(Paths.get(file));
			input.nextLine();
			input_name = new Scanner(Paths.get(file));
			input_name.nextLine();
			input_dob = new Scanner(Paths.get(file));
			input_dob.nextLine();
			input_registered = new Scanner(Paths.get(file));
			input_registered.nextLine();
			input_picture = new Scanner(Paths.get(file));
			input_picture.nextLine();
			input_location = new Scanner(Paths.get(file));
			input_location.nextLine();
			input_coordinates = new Scanner(Paths.get(file));
			input_coordinates.nextLine();
			input_timezone = new Scanner(Paths.get(file));
			input_timezone.nextLine();
			
			
			// Adiciona nome (title, first, last)
			while(input.hasNext()) {
				String[] data = input.nextLine().split(";");

				Results results = new Results();

				results.setGender(data[0]);
				results.setEmail(data[12]);
				results.setPhone(data[17]);
				results.setCell(data[18]);

				PessoaDao dao = new PessoaDao();
				dao.adiciona(results);
			}
					
			// Adiciona nome (title, first, last)
			int count_fk_name = 1;
			while(input_name.hasNext() && count_fk_name <= 1000) {
				String[] data = input_name.nextLine().split(";");
				
				Name name_list = new Name();
				
				name_list.setTitle(data[1]);
				name_list.setFirst(data[2]);
				name_list.setLast(data[3]);

				Results results_id = new Results();
				results_id.setId(count_fk_name++);
				
				name_list.setResults(results_id);
	
				List<Name> name = new ArrayList<>();
				name.add(name_list);

				Results results_name = new Results();
				results_name.setName(name);

				PessoaDao dao = new PessoaDao();
				dao.adiciona(results_name);			
			}
			
			// Adiciona dob (date, age[age tirado])
			int count_fk_dob = 1;
			while(input_dob.hasNext() && count_fk_dob <= 1000) {
				String[] data = input_dob.nextLine().split(";");

				Dob dob_list = new Dob();
				dob_list.setDate(data[13]);
				
				Results results_id = new Results();
				results_id.setId(count_fk_dob++);
				
				dob_list.setResults(results_id);
				
				List<Dob> dob = new ArrayList<>();
				dob.add(dob_list);

				Results results_dob = new Results();
				results_dob.setDob(dob);
				
				PessoaDao dao = new PessoaDao();
				dao.adiciona(results_dob);
			}
			
			// Adiciona registered (date, age[age tirado])
			int count_fk_registered = 1;
			while(input_registered.hasNext() && count_fk_registered <= 1000) {
				String[] data = input_registered.nextLine().split(";");
				
				Registered registered_list = new Registered();
				registered_list.setDate(data[15]);
				
				Results results_id = new Results();
				results_id.setId(count_fk_registered++);
				
				registered_list.setResults(results_id);
				
				List<Registered> registered = new ArrayList<>();
				registered.add(registered_list);

				Results results_registered = new Results();
				results_registered.setRegistered(registered);
				
				PessoaDao dao = new PessoaDao();
				dao.adiciona(results_registered);
			}
			  

			// Adiciona picture (large, medium, thumbnail)
			int count_fk_picture = 1;
			while(input_picture.hasNext() && count_fk_picture <= 1000) {
				String[] data = input_picture.nextLine().split(";");
				
				Picture picture_list = new Picture();
				picture_list.setLarge(data[19]);
				picture_list.setMedium(data[20]);
				picture_list.setThumbnail(data[21]);
				
				Results results_id = new Results();
				results_id.setId(count_fk_picture++);
				
				picture_list.setResults(results_id);
						
				List<Picture> picture = new ArrayList<>();
				picture.add(picture_list);

				Results results_picture = new Results();
				results_picture.setPicture(picture);
				
				PessoaDao dao = new PessoaDao();
				dao.adiciona(results_picture);
				
			}
			
			
			// Adiciona location (street, city, state, postcode)
			int count_fk_location = 1;
			while(input_location.hasNext() && count_fk_location <= 1000) {
				String[] data = input_location.nextLine().split(";");

				Location location_list = new Location();
				location_list.setStreet(data[4]);
				location_list.setCity(data[5]);
				location_list.setState(data[6]);
				location_list.setPostcode(data[7]);
				
				Results results_id = new Results();
				results_id.setId(count_fk_location++);
				
				location_list.setResults(results_id);

				List<Location> location = new ArrayList<>();
				location.add(location_list);

				Results results_location = new Results();
				results_location.setLocation(location);
				
				PessoaDao dao = new PessoaDao();
				dao.adiciona(results_location);
	
			}
			
			
			// Adiciona coordinates (latitude, longitude)
			int count_fk_coordinates = 1;
			while(input_coordinates.hasNext() && count_fk_coordinates <= 1000) {
				String[] data = input_coordinates.nextLine().split(";");

				Coordinates coordinate_list = new Coordinates();
				coordinate_list.setLatitude(data[8]);
				coordinate_list.setLongitude(data[9]);
				
				Location location_id = new Location();
				location_id.setId(count_fk_coordinates++);
				
				coordinate_list.setLocation(location_id);
				
				List<Coordinates> coordinates = new ArrayList<>();
				coordinates.add(coordinate_list);

				Location location_coordinates = new Location();
				location_coordinates.setCoordinates(coordinates);
				
				List<Location> location = new ArrayList<>();
				location.add(location_coordinates);
				
				Results results_location_coordinates = new Results();
				results_location_coordinates.setLocation(location);
				
				PessoaDao dao = new PessoaDao();
				dao.adiciona(results_location_coordinates);
			}
			
			
			// Adiciona timezone (offset, description)
			int count_fk_timezone = 1;
			while(input_timezone.hasNext() && count_fk_timezone <= 1000) {
				String[] data = input_timezone.nextLine().split(";");

				Timezone timezone_list = new Timezone();
				timezone_list.setOffset(data[10]);
				timezone_list.setDescription(data[11]);
				
				Location location_id = new Location();
				location_id.setId(count_fk_timezone++);
				
				timezone_list.setLocation(location_id);

				List<Timezone> timezone = new ArrayList<>();
				timezone.add(timezone_list);

				Location location_timezone = new Location();
				location_timezone.setTimezones(timezone);
				
				List<Location> location = new ArrayList<>();
				location.add(location_timezone);
				
				Results results_location_timezone = new Results();
				results_location_timezone.setLocation(location);
				
				PessoaDao dao = new PessoaDao();
				dao.adiciona(results_location_timezone);
			}
			
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		return dao;	
	}	

}
