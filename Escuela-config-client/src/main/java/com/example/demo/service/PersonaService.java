package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entidad.Persona;
import com.example.demo.exceptions.ResourceNotFoundException;


public interface PersonaService {
	 
	public List<Persona> obtenerPersonas();
	
	public Persona guardarPersona(Persona persona) throws Exception;
	
	public Persona obtenerPersonaPorId(long id) throws ResourceNotFoundException;
	
	public Long obtenerCantidad();
	
	public void eliminarPersona(long id);

}
