package com.example.demo.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;

//import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PersonaDTO;
import com.example.demo.dto.PersonaReducidaDTO;
import com.example.demo.entidad.Persona;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.service.PersonaService;

@RestController
public class PersonaController {

	@Autowired
	private PersonaService personaService;

	@GetMapping("/personas")
	public Iterable<Persona> obtenerPersonas(){
		Iterable<Persona> data = personaService.obtenerPersonas();
		return data;
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/personas")
	public PersonaDTO guardarPersona(@Valid @RequestBody PersonaReducidaDTO persona) {
		ModelMapper mapper = new ModelMapper();
		Persona nuevo = personaService.guardarPersona(mapper.map(persona, Persona.class));
		return mapper.map(nuevo, PersonaDTO.class);
	}
	
	@GetMapping("/personas/{id}")
	public Persona obtenerPersonaPorId(@PathVariable("id") Long id) throws ResourceNotFoundException {
//	public Optional<Persona> obtenerPersonaPorId(@PathVariable("id") Long id) {
		return personaService.obtenerPersonaPorId(id);
	}
	
	
	
	
//	@RequestMapping("/personas")
//	public List<Persona> getPersona() {
//		return personaService.obtenerPersonas();
//	}

//	@Value("${palabra}")
//	String palabra;
//	
//	@RequestMapping("/palabra")
//	public String obtenerPalabra() {
//		return "La palabra obtenida es: " + palabra;
//	}
}
