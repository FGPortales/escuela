package com.example.demo.entidad;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Compania {

	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="nombre")
	private String nombre;
	@Column(name="ruc")
	private String ruc;
	@Column(name="razonsocial")
	private String razonsocial;
	
	@OneToMany(mappedBy = "compania",cascade = CascadeType.ALL)
	private List<Persona> personas;
	
	
}
