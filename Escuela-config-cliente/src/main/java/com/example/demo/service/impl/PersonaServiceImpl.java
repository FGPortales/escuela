package com.example.demo.service.impl;

import java.util.List;
//import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidad.Persona;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repository.PersonaRepository;
import com.example.demo.service.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService {
	
	@Autowired
	private PersonaRepository personaRepository;

	@Override
	public List<Persona> obtenerPersonas() {
		// TODO Auto-generated method stub
		return StreamSupport.stream(personaRepository.findAll().spliterator(), false).collect(Collectors.toList());
	}

	@Override
	public Persona guardarPersona(Persona persona) {
		return personaRepository.save(persona);	
	}

	@Override
	public Persona obtenerPersonaPorId(Long id) throws ResourceNotFoundException{
//	public Optional<Persona> obtenerPersonaPorId(Long id){
//		return personaRepository.findById(id);
		return personaRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(String.format("No se encontro el id %s en la BD", id)));
	}
}
