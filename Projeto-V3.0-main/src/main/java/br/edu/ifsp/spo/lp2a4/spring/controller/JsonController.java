package br.edu.ifsp.spo.lp2a4.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.edu.ifsp.spo.lp2a4.spring.dao.PessoaDao;
import br.edu.ifsp.spo.lp2a4.spring.model.Pessoa;
import br.edu.ifsp.spo.lp2a4.spring.model.Results;
import br.edu.ifsp.spo.lp2a4.spring.model.Coordinates;
import br.edu.ifsp.spo.lp2a4.spring.model.Dob;
import br.edu.ifsp.spo.lp2a4.spring.model.Location;
import br.edu.ifsp.spo.lp2a4.spring.model.Name;
import br.edu.ifsp.spo.lp2a4.spring.model.Picture;
import br.edu.ifsp.spo.lp2a4.spring.model.Registered;
import br.edu.ifsp.spo.lp2a4.spring.model.Timezone;

@RestController
@RequestMapping("/")
public class JsonController {
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Pessoa pessoas = restTemplate.getForObject("https://storage.googleapis.com/juntossomosmais-code-challenge/input-backend.json", Pessoa.class);

			JSONObject obj = new JSONObject(pessoas);

			JSONArray Resultados = obj.getJSONArray("results");

			String[] genero = new String[Resultados.length()];
			String[] email = new String[Resultados.length()];
			String[] phone = new String[Resultados.length()];
			String[] cell = new String[Resultados.length()];

			// Adiciona Pessoa (Gender, Email, Phone, Cell)
			for (int i = 0; i < Resultados.length(); i++) {

				genero[i] = Resultados.getJSONObject(i).getString("gender");
				email[i] = Resultados.getJSONObject(i).getString("email");
				phone[i] = Resultados.getJSONObject(i).getString("phone");
				cell[i] = Resultados.getJSONObject(i).getString("cell");

				Results results_pessoa = new Results();
				results_pessoa.setGender(genero[i]);
				results_pessoa.setEmail(email[i]);
				results_pessoa.setPhone(phone[i]);
				results_pessoa.setCell(cell[i]);
				
				PessoaDao dao = new PessoaDao();
				//dao.adiciona(results_pessoa);				
			}

			// Adiciona nome (title, first, last)
			for (int i = 0; i < Resultados.length(); i++) {
				JSONObject jsonObj = Resultados.getJSONObject(i);

				JSONArray jarray = jsonObj.getJSONArray("name");

				for (int j = 0; j < jarray.length(); j++) {

					String value = jarray.getString(j);
					JSONObject obj3 = new JSONObject(value);

					String title = obj3.getString("title");
					String first = obj3.getString("first");
					String last = obj3.getString("last");

					Results results_id = new Results();
					results_id.setId(i + 1);

					Name name_list = new Name();
					name_list.setTitle(title);
					name_list.setFirst(first);
					name_list.setLast(last);
					name_list.setResults(results_id);


					List<Name> name = new ArrayList<>();
					name.add(name_list);

					Results results_name = new Results();
					results_name.setName(name);

					PessoaDao dao = new PessoaDao();
					//dao.adiciona(results_name);
				}

			}

			// Adiciona dob (date, age[age tirado])
			for (int i = 0; i < Resultados.length(); i++) {
				JSONObject jsonObj = Resultados.getJSONObject(i);

				JSONArray jarray = jsonObj.getJSONArray("dob");

				for (int j = 0; j < jarray.length(); j++) {

					String value = jarray.getString(j);
					JSONObject obj3 = new JSONObject(value);
					//System.out.println(obj3);

					String date = obj3.getString("date");
					//int age = obj3.getInt("age");

					Results results_id = new Results();
					results_id.setId(i + 1);

					Dob dob_list = new Dob();
					dob_list.setDate(date);
					dob_list.setResults(results_id);

					List<Dob> dob = new ArrayList<>();
					dob.add(dob_list);

					Results results_dob = new Results();
					results_dob.setDob(dob);

					PessoaDao dao = new PessoaDao();
					//dao.adiciona(results_dob);
				}

			}

			// Adiciona registered (date, age[age tirado])
			for (int i = 0; i < Resultados.length(); i++) {
				JSONObject jsonObj = Resultados.getJSONObject(i);

				JSONArray jarray = jsonObj.getJSONArray("registered");

				for (int j = 0; j < jarray.length(); j++) {

					String value = jarray.getString(j);
					JSONObject obj3 = new JSONObject(value);

					String date = obj3.getString("date");

					Results results_id = new Results();
					results_id.setId(i + 1);

					Registered registered_list = new Registered();
					registered_list.setDate(date);
					registered_list.setResults(results_id);

					List<Registered> registered = new ArrayList<>();
					registered.add(registered_list);

					Results results_registered = new Results();
					results_registered.setRegistered(registered);

					PessoaDao dao = new PessoaDao();
					//dao.adiciona(results_registered);
				}

			}

			// Adiciona picture (large, medium, thumbnail)
			for (int i = 0; i < Resultados.length(); i++) {
				JSONObject jsonObj = Resultados.getJSONObject(i);

				JSONArray jarray = jsonObj.getJSONArray("picture");

				for (int j = 0; j < jarray.length(); j++) {

					String value = jarray.getString(j);
					JSONObject obj3 = new JSONObject(value);

					String large = obj3.getString("large");
					String medium = obj3.getString("medium");
					String thumbnail = obj3.getString("thumbnail");

					Results results_id = new Results();
					results_id.setId(i + 1);

					Picture picture_list = new Picture();
					picture_list.setLarge(large);
					picture_list.setMedium(medium);
					picture_list.setThumbnail(thumbnail);
					picture_list.setResults(results_id);

					List<Picture> picture = new ArrayList<>();
					picture.add(picture_list);

					Results results_picture = new Results();
					results_picture.setPicture(picture);

					PessoaDao dao = new PessoaDao();
					//dao.adiciona(results_picture);
				}

			}

			// Adiciona location (street, city, state, postcode)
			for (int i = 0; i < Resultados.length(); i++) {
				JSONObject jsonObj = Resultados.getJSONObject(i);

				JSONArray jarray = jsonObj.getJSONArray("location");

				for (int j = 0; j < jarray.length(); j++) {

					String value = jarray.getString(j);
					JSONObject obj3 = new JSONObject(value);

					String street = obj3.getString("street");
					String city = obj3.getString("city");
					String state = obj3.getString("state");
					String postcode = Integer.toString(obj3.getInt("postcode"));

					Results results_id = new Results();
					results_id.setId(i + 1);

					Location location_list = new Location();
					location_list.setStreet(street);
					location_list.setCity(city);
					location_list.setState(state);
					location_list.setPostcode(postcode);
					location_list.setResults(results_id);

					List<Location> location = new ArrayList<>();
					location.add(location_list);

					Results results_location = new Results();
					results_location.setLocation(location);

					PessoaDao dao = new PessoaDao();
					//dao.adiciona(results_location);
				}

			}

			// Adiciona coordinates (latitude, longitude)
			for (int i = 0; i < Resultados.length(); i++) {
				JSONObject jsonObj = Resultados.getJSONObject(i);

				JSONArray jarray = jsonObj.getJSONArray("location");;

				for (int j = 0; j < jarray.length(); j++) {

					String value = jarray.getString(j);
					JSONObject obj3 = new JSONObject(value);

					JSONObject jsonArray = obj3.getJSONObject("coordinates");

					String latitude = jsonArray.getString("latitude");
					String longitude = jsonArray.getString("longitude");

					Location location_id = new Location();
					location_id.setId(i + 1);

					Coordinates coordinates_list = new Coordinates();
					coordinates_list.setLocation(location_id);
					coordinates_list.setLatitude(latitude);
					coordinates_list.setLongitude(longitude);

					List<Coordinates> coordinates = new ArrayList<>();
					coordinates.add(coordinates_list);

					Location location_coordinates = new Location();
					location_coordinates.setCoordinates(coordinates);

					List<Location> location = new ArrayList<>();
					location.add(location_coordinates);

					Results results_location_coordinates = new Results();
					results_location_coordinates.setLocation(location);

					PessoaDao dao = new PessoaDao();
					//dao.adiciona(results_location_coordinates);
				}

			}

			// Adiciona timezone (offset, description)
			for (int i = 0; i < Resultados.length(); i++) {
				JSONObject jsonObj = Resultados.getJSONObject(i);

				JSONArray jarray = jsonObj.getJSONArray("location");;

				for (int j = 0; j < jarray.length(); j++) {

					String value = jarray.getString(j);
					JSONObject obj3 = new JSONObject(value);

					JSONObject jsonArray = obj3.getJSONObject("timezone");

					String offset = jsonArray.getString("offset");
					String description = jsonArray.getString("description");

					Location location_id = new Location();
					location_id.setId(i + 1);

					Timezone timezone_list = new Timezone();
					timezone_list.setLocation(location_id);
					timezone_list.setOffset(offset);
					timezone_list.setDescription(description);

					List<Timezone> timezone = new ArrayList<>();
					timezone.add(timezone_list);

					Location location_timezone = new Location();
					location_timezone.setTimezones(timezone);

					List<Location> location = new ArrayList<>();
					location.add(location_timezone);

					Results results_location_timezone = new Results();
					results_location_timezone.setLocation(location);

					PessoaDao dao = new PessoaDao();
					//dao.adiciona(results_location_timezone);
				}

			}
			
		};


	}		
}
