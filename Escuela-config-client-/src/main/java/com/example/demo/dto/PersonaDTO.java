package com.example.demo.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.metamodel.StaticMetamodel;

import com.example.demo.entidad.Persona;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PersonaDTO {
	private Long id;
	@JsonProperty(value = "nombre")
	private String nombre;
	@JsonProperty(value = "apellido_paterno")
	private String apellido1;
	@JsonProperty(value = "apellido_materno")
	private String apellido2;
	private String dni;
	private CompaniaReducidaDTO compania;
}
