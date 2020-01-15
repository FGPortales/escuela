package com.example.demo.service.impl;

import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entidad.Persona;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.exceptions.ValidationDniException;
import com.example.demo.service.PersonaService;


import com.example.demo.repository.PersonaRepository;
@Transactional(readOnly = true)
@Service
public class PersonaServiceImpl implements PersonaService{
	
	@Autowired
	private PersonaRepository personaRepository;
	
	@Override
	public List<Persona> obtenerPersonas()
	{		
		return StreamSupport.stream(personaRepository.findAll().spliterator(), false).collect(Collectors.toList());	
	}

	@Transactional(readOnly = false)
	@Override
	public Persona guardarPersona(Persona persona) throws Exception  {
		// TODO Auto-generated method stub
		
		if (personaRepository.findByDni(persona.getDni()).isPresent())
		{		
			throw new ValidationDniException("el dni esta repetido");
		}		
		Persona pers = personaRepository.save(persona);
		personaRepository.refresh(pers);
		return pers ;		
		
	}
	
	
	
	@Override
	public Persona obtenerPersonaPorId(long id) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return personaRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(String.format("No se encontro el ID %l en la bd.",id)));		
	}
	
	@Override
	public Long obtenerCantidad() {
		// TODO Auto-generated method stub
		return personaRepository.count();
	}


	@Override
	public void eliminarPersona(long id) {
		// TODO Auto-generated method stub
		personaRepository.deleteById(id);
	}
	
	

	
}





