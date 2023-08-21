package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Person;
import com.example.services.PersonServices;


@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonServices personservices;
	
	@RequestMapping(method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	 public List<Person> findAll(){
		
		return personservices.findAll();
	}
	
	@RequestMapping(value = "/{id}", 
		 method= RequestMethod.GET,
		 produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findById(
			@PathVariable(value = "id") Long idPerson) throws Exception{

		return personservices.findById(idPerson); 
	 }
	
	@RequestMapping(method = RequestMethod.POST,
			 consumes = MediaType.APPLICATION_JSON_VALUE,
			 produces = MediaType.APPLICATION_JSON_VALUE)
    public Person create(@RequestBody Person person) {
		
		
		return personservices.create(person);
	}
	
	@RequestMapping(method = RequestMethod.PUT,
			 consumes = MediaType.APPLICATION_JSON_VALUE,
			 produces = MediaType.APPLICATION_JSON_VALUE)
   public Person update(@RequestBody Person person) {
		
		return personservices.update(person);
	}
	
	@RequestMapping(value = "/{id}", 
			 method= RequestMethod.DELETE)
		public void delete(
				@PathVariable(value = "id") Long idPerson) throws Exception{
		   personservices.delete(idPerson);
		 }
	
	}
