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
public class CompaniaDTO {
	private Long id;
	private String nombre;
	private String ruc;
	@JsonProperty(value = "razon_social")
	private String razonSocial;
	private List<PersonaDTO> personas;

}
