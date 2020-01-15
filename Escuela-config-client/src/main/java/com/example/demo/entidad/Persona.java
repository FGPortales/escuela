package com.example.demo.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.UniqueElements;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//javabean 
// clase publica con atributos privados y cuenta con setter y getter y cuenta con un constructor sin argumentos

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Persona {
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="nombre")
	private String nombre;
	@Column(name="apellido1")
	private String apellido1;
	@Column(name="apellido2")
	private String apellido2;	
	@Column(name="dni",unique = true)	
	private String dni;
	

    @ManyToOne     
    private Compania compania;
	
	
	
	
}
