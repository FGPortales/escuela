package com.example.demo.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.type.TrueFalseType;

import com.example.demo.service.PersonaService;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String nombre;
	@Column
	private String apellido1;
	@Column
	private String apellido2;
	@Column(name = "dni", unique = true)
	private String dni;
	@ManyToOne
	private Compania compania;
}
