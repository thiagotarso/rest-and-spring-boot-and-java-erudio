package com.example.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.example.model.Person;

@Service
public class PersonServices {

	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	public List<Person> findAll() {
		logger.info("Finding All persons!");
		
		List<Person> persons = new ArrayList<>();
		
        for (int i = 0; i < 8; i++) {
        	  Person person =  mockPerson(i);
        	  persons.add(person);
			}	
		
		return persons;
	}
	

	public Person findById(String id) {
		
		logger.info("Finding one person!");
		
		Person person = new Person();
		
		person.setId(counter.incrementAndGet());
		person.setNombre("Thiago tarso da silva");
		person.setDocumento("x9000900Q");
		person.setDireccion("Avenida diego");
		person.setCodigoPostal("03180");
		person.setCiudad("Torrevieja");
		person.setProvincia("Alicante");
	
		return person;
		
	} 
	
	private Person mockPerson(int i) {
	
        Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setNombre("person nombre" +i);
		person.setDocumento("Last Documento" +i);
		person.setDireccion("Direcion" +i);
		person.setCodigoPostal("Codipo postal" +i);
		person.setCiudad("Ciudad" +i);
		person.setProvincia("Provincia" +i);
		
		return person;
	}
	
}
