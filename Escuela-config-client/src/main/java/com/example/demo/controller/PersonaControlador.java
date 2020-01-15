
package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.PersonaDTO;
import com.example.demo.DTO.PersonaReducidaDTO;
import com.example.demo.entidad.Persona;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.service.impl.PersonaServiceImpl;

@RestController
public class PersonaControlador {

	@Autowired
	private PersonaServiceImpl personaService;
//	@GetMapping
//	@PostMapping
//	@PutMapping	
	@GetMapping("/personas")	
	public List<PersonaDTO> getPersonas() {
		
		ModelMapper modelMapper = new ModelMapper();
		return StreamSupport.stream(personaService.obtenerPersonas().spliterator(), false)
				.map(c -> modelMapper.map(c, PersonaDTO.class)).collect(Collectors.toList());
		
	}
	
	

	@PostMapping("/personas")
//	@RequestMapping( path = "/persona",method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
//	public ResponseEntity<Persona> setguardar(@RequestBody Persona persona) {
	public PersonaDTO setguardar(@Valid @RequestBody PersonaReducidaDTO persona) throws Exception  {
		ModelMapper modelMapper = new ModelMapper();
		Persona pers = personaService.guardarPersona(modelMapper.map(persona,Persona.class));
		return modelMapper.map(pers, PersonaDTO.class);
	}
	
	
	@GetMapping("/personas/{id}")
//	@RequestMapping( path = "/persona",method = RequestMethod.POST)
	public Persona obtenerPersonaPorId(@PathVariable("id") long id) throws ResourceNotFoundException{
		return personaService.obtenerPersonaPorId(id);
		
	}
	
	@GetMapping("/personas/cantidad")
//	@RequestMapping( path = "/persona",method = RequestMethod.POST)
	public String  obtenerCantidadPersona() {
		return "la cantidad de personas es : "+ personaService.obtenerCantidad();
		
	}
	
	@GetMapping("/personas/Eliminar/{id}")
//	@RequestMapping( path = "/persona",method = RequestMethod.POST)
	public String  eliminarPersonaPorId(@PathVariable("id") long id) {
		try {
			personaService.eliminarPersona(id);
			return "se elimino correctamente";
		} catch (Exception e) {
			return "Ocurrio un inconveniente, no se puedo eliminar persona.";
		} 
		
	}	
	
	
	

}
