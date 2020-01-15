package com.example.demo.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.metamodel.StaticMetamodel;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.example.demo.entidad.Persona;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PersonaReducidaDTO {
	@NotNull
	@NotBlank
	@Size(max = 20)
	private String nombre;
	
	@JsonProperty(value = "apellido_paterno")
	@NotNull
	@NotBlank
	@Size(max = 50)
	private String apellido1;
	
	@JsonProperty(value = "apellido_materno")
	@Size(max = 50)
	private String apellido2;
	private String dni;

}
