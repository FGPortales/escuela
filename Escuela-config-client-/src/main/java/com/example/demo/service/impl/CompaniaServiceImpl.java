package com.example.demo.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CompaniaDTO;
import com.example.demo.dto.CompaniaReducidaDTO;
import com.example.demo.entidad.Compania;
import com.example.demo.entidad.Persona;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repository.CompaniaRepository;
import com.example.demo.repository.PersonaRepository;
import com.example.demo.service.CompaniaService;

@Service
public class CompaniaServiceImpl implements CompaniaService {
	
	@Autowired
	private CompaniaRepository companiaRepository;
	
	@Autowired
	private PersonaRepository personaRepository;

	@Override
	public Iterable<Compania> obtenerCompanias(){
		
		return companiaRepository.findAll();
	}
	
	//@Transactional(readOnly = false)
//	@Override
//	public Compania asociarCompaniaPersona(Long idCompania, Long idPersona) throws ResourceNotFoundException {
//		Persona persona = personaRepository.findById(idPersona)
//				.orElseThrow(() -> new ResourceNotFoundException("No se encontro la persona con el id"));
////		Compania compania = companiaRepository.findById(idCompania)
////				.orElseThrow(()-> new ResourceNotFoundException))("No se encontro")
//
//	}

	@Override
	public Persona guardarPersona(Persona persona) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Persona obtenerPersonaPorId(Long id) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Compania actualizarCompania(Long idCompania, CompaniaReducidaDTO companiaReducidaDto) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Compania compania = companiaRepository.findById(idCompania).orElseThrow(()-> new ResourceNotFoundException("No se encontro la compania"));
		compania.setNombre(companiaReducidaDto.getNombre());
		compania.setRuc(companiaReducidaDto.getRuc());
		compania.setRazonSocial(companiaReducidaDto.getRazonSocial());
		
		Compania nuevaCompania = companiaRepository.save(compania);
		//companiaRepository.refresh(nuevaCompania);
		return nuevaCompania;
	}

	@Override
	public Compania asociarCompaniaPersona(Long idCompania, Long idPersona) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}


}