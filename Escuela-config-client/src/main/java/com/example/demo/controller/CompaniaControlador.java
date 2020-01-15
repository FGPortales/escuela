
package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.CompaniaDTO;
import com.example.demo.DTO.CompaniaReducidaDTO;
import com.example.demo.entidad.Compania;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.service.impl.CompaniaServiceImpl;

@RestController
public class CompaniaControlador {

	
	@Autowired
	private CompaniaServiceImpl companiaService;

//	@GetMapping
//	@PostMapping
//	@PutMapping	
	@GetMapping("/companias")	
	public List<CompaniaDTO> getCompanias() {
//		//defino la variable de retorno 
//		List<CompaniaDTO> response =  new ArrayList<CompaniaDTO>();
//		//obtengo las compañias del servicio
//		Iterable<Compania> listado = companiaService.obtenerCompanias();
//		//defino la isntancia del modelmapper
//		ModelMapper modelMapper = new ModelMapper();
//		//recorro mi lustado y agrego a mi variable de retorno
//		listado.forEach(compania->{
//			CompaniaDTO companiaDTO = modelMapper.map(compania,CompaniaDTO.class);
//			response.add(companiaDTO);
//		});		
//		
//		return response;	
		
		
		ModelMapper modelMapper = new ModelMapper();
		return StreamSupport.stream(companiaService.obtenerCompanias().spliterator(), false)
				.map(c -> modelMapper.map(c, CompaniaDTO.class)).collect(Collectors.toList());
		
	}
	
	

	@PostMapping("/companias")
//	@RequestMapping( path = "/compania",method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
//	public ResponseEntity<Persona> setguardar(@RequestBody Persona persona) {
	public Compania setguardar(@RequestBody Compania compania) {
		 return companiaService.guardarCompania(compania);
//		 return ResponseEntity.status(HttpStatus.CREATED).body(personaService.guardarPersona(persona));
		
	}
	
	
	@GetMapping("/companias/{id}")
//	@RequestMapping( path = "/compania",method = RequestMethod.POST)
	public Compania obtenerCompaniaPorId(@PathVariable("id") long id) throws ResourceNotFoundException{
		return companiaService.obtenerCompaniaPorId(id);
		
	}
	
	@GetMapping("/companias/cantidad")
//	@RequestMapping( path = "/compania",method = RequestMethod.POST)
	public String  obtenerCantidadCompania() {
		return "la cantidad de personas es : "+ companiaService.obtenerCantidad();
		
	}
	
	@GetMapping("/companias/Eliminar/{id}")
//	@RequestMapping( path = "/compania",method = RequestMethod.POST)
	public String  eliminarCompaniaPorId(@PathVariable("id") long id) {
		try {
			companiaService.eliminarCompania(id);
			return "se elimino correctamente";
		} catch (Exception e) {
			return "Ocurrio un inconveniente, no se puedo eliminar persona.";
		} 
		
	}	
	
	
	@PutMapping("/compania/{idcompania}/persona/{idpersona}") 
//	@RequestMapping( path = "/compania",method = RequestMethod.POST)
	public CompaniaDTO asociarCompaniaPersona(@PathVariable("idcompania") long idcompania,@PathVariable("idpersona") long idpersona) throws ResourceNotFoundException{
		
		
		ModelMapper modelMapper = new ModelMapper();		
		return modelMapper.map(companiaService.asociarCompaniaPersona(idcompania,idpersona), CompaniaDTO.class);
		
		
	}
	
	@PutMapping("/compania/{id}")
//	@RequestMapping( path = "/compania",method = RequestMethod.POST)
	public CompaniaDTO actualizarCompania(@PathVariable("id") long id,@RequestBody CompaniaReducidaDTO companiadto) throws ResourceNotFoundException{
		
		ModelMapper modelMapper = new ModelMapper();
		
		return modelMapper.map(companiaService.actualizarCompania(id, companiadto), CompaniaDTO.class);
	}
	
	
	
	

}
