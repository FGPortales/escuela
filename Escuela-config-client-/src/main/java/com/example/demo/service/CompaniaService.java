package com.example.demo.service;

import java.util.List;
//import java.util.Optional;

import com.example.demo.dto.CompaniaDTO;
import com.example.demo.dto.CompaniaReducidaDTO;
import com.example.demo.entidad.Compania;
import com.example.demo.entidad.Persona;
import com.example.demo.exceptions.ResourceNotFoundException;

public interface CompaniaService {
	//public List<Compania> obtenerCompanias();
	//public Iterable<Compania> obtenerCompanias();
	public Persona guardarPersona(Persona persona);
	public Persona obtenerPersonaPorId(Long id) throws ResourceNotFoundException;
//	public Optional<Persona> obtenerPersonaPorId(Long id);
	//public Iterable<Compania> obtenerCompanias();
	public Iterable<Compania> obtenerCompanias();
	Compania asociarCompaniaPersona(Long idCompania, Long idPersona) throws ResourceNotFoundException;
//	public Compania actualizarCompania(Long idCompania, CompaniaDTO companiaDto) throws ResourceNotFoundException;
	Compania actualizarCompania(Long idCompania, CompaniaReducidaDTO companiaReducidaDto)
			throws ResourceNotFoundException;
	
}
