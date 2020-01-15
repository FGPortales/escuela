package com.example.demo.service;

import java.util.List;
//import java.util.Optional;

import com.example.demo.entidad.Compania;
import com.example.demo.entidad.Persona;
import com.example.demo.exceptions.ResourceNotFoundException;

public interface CompaniaService {
	public List<Persona> obtenerPersonas();
	public Persona guardarPersona(Persona persona);
	public Persona obtenerPersonaPorId(Long id) throws ResourceNotFoundException;
//	public Optional<Persona> obtenerPersonaPorId(Long id);
	public Iterable<Compania> obtenerCompanias();
	
}