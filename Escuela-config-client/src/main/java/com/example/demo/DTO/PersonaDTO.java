package com.example.demo.DTO;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PersonaDTO {
	private Long  id;	
	@JsonProperty(value= "Nombre")
	@NotNull
	@NotBlank
	@Size(max = 20)
	private String nombre;
	
	@JsonProperty(value= "Apellido_Paterno")	
	@NotNull
	@NotBlank
	@Size(max = 50)
	private String apellido1;	
	@JsonProperty(value= "Apellido_Materno")
	@Size(max = 50)
	private String apellido2;
	@NotNull
	@NotBlank
	@Size(max = 8)
	private String dni;         
	
	private CompaniaReducidaDTO compania;
	
}
