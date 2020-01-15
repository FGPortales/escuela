package com.example.demo.service;

import com.example.demo.DTO.CompaniaReducidaDTO;
import com.example.demo.entidad.Compania;
import com.example.demo.exceptions.ResourceNotFoundException;

public interface CompaniaService {

	
	public Iterable<Compania> obtenerCompanias();
	
	public Compania guardarCompania(Compania compania);
	
	public Compania obtenerCompaniaPorId(long id) throws ResourceNotFoundException;
	
	public Long obtenerCantidad();
	
	public void eliminarCompania(long id);
	
	public Compania asociarCompaniaPersona(Long idcompania,Long idpersona ) throws ResourceNotFoundException;
	public Compania actualizarCompania(long id,CompaniaReducidaDTO companiadto) throws ResourceNotFoundException;
	
}
