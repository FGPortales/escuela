package com.example.demo.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.metamodel.StaticMetamodel;

import com.example.demo.entidad.Persona;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PersonaDTO {
	private Long id;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String dni;
	private CompaniaReducidaDTO compania;
}
