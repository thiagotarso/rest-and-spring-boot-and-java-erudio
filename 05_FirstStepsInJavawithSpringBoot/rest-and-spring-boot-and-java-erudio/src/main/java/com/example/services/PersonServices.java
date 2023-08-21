package com.example.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exceptions.ResourceNotFoundException;
import com.example.model.Person;
import com.example.repositories.PersonRepository;

@Service
public class PersonServices {

	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	PersonRepository respository;
	
	public List<Person> findAll() {
		logger.info("Finding All persons!");

		return respository.findAll();
	}
	

	public Person findById(Long id) {
		
		logger.info("Finding one person!");
		
		Person person = new Person();
		
		person.setNombre("Thiago tarso da silva");  
		person.setDocumento("x9000900Q");
		person.setDireccion("Avenida diego");
		person.setCodigoPostal("03180");
		person.setCiudad("Torrevieja");
		person.setProvincia("Alicante");
	
		return respository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("no records found for this ID"));
		
	} 
	
	public Person create(Person person) { 
		
		logger.info("create one person!");
		
	return respository.save(person);	
	}
	
    public Person update(Person person) { 
		
		logger.info("updating one person!");
		
		Person entity = respository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("no records found for this ID"));

		entity.setNombre(person.getNombre());
		entity.setDireccion(person.getDireccion());
		entity.setDocumento(person.getDocumento());
		entity.setCiudad(person.getCiudad());
		entity.setProvincia(person.getProvincia());
		entity.setCodigoPostal(person.getCodigoPostal());
		
	    return respository.save(entity);
    }
    
   public void delete(Long id) { 
		
		logger.info("delete one person!");
		
		Person entity = respository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("no records found for this ID"));
		
		respository.delete(entity);
	} 
		
		
}
