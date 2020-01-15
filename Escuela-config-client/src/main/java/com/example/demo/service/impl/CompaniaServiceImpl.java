package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.DTO.CompaniaReducidaDTO;
import com.example.demo.entidad.Compania;
import com.example.demo.entidad.Persona;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repository.CompaniaRepository;
import com.example.demo.repository.PersonaRepository;
import com.example.demo.service.CompaniaService;

@Transactional(readOnly = true)
@Service
public class CompaniaServiceImpl implements CompaniaService{
	
	@Autowired
	private CompaniaRepository companiaRepository;
	@Autowired
	private PersonaRepository personaRepository;
	
	@Override
	public Iterable<Compania> obtenerCompanias()
	{		
		return companiaRepository.findAll();	
	}

	@Override
	@Transactional(readOnly = false) //solo esta funcion no va a ser solo de lectura
	public Compania guardarCompania(Compania compania) {
		// TODO Auto-generated method stub
		Compania companiatemp =  companiaRepository.save(compania);
		companiaRepository.refresh(companiatemp);
		return companiatemp;
		
		
	}

	@Override
	public Compania obtenerCompaniaPorId(long id) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return companiaRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(String.format("No se encontro el ID %s en la bd.",id)));		
	}
	
	@Override
	public Long obtenerCantidad() {
		// TODO Auto-generated method stub
		return companiaRepository.count();
	}


	@Override
	public void eliminarCompania(long id) {
		// TODO Auto-generated method stub
		companiaRepository.deleteById(id);
	}

	@Override
	@Transactional(readOnly = false) //solo esta funcion no va a ser solo de lectura
	public Compania asociarCompaniaPersona(Long idcompania,Long idpersona) throws ResourceNotFoundException {
		
				
		Persona persona = personaRepository.findById(idpersona).orElseThrow(()-> new ResourceNotFoundException("No se encontro persona"));		
		Compania compania = companiaRepository.findById(idcompania).orElseThrow(()-> new ResourceNotFoundException("No se encontro compania"));;		
		persona.setCompania(compania);
		personaRepository.save(persona);
		compania = companiaRepository.findById(idcompania).get();
		companiaRepository.refresh(compania);
		return compania;
		
		
	}
	@Transactional(readOnly = false)
	@Override		
	public Compania actualizarCompania(long id,CompaniaReducidaDTO companiadto) throws ResourceNotFoundException {
		Compania compania = companiaRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No se Encontro la Compañia"));
		compania.setNombre(companiadto.getNombre());
		compania.setRazonsocial(companiadto.getRazonsocial());
		compania.setRuc(companiadto.getRuc());
		
		Compania companiatemp =  companiaRepository.save(compania);
		//companiaRepository.refresh(companiatemp);
		return companiatemp;
	}
	

	
	
}





