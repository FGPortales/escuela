package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.Repository;

import com.example.demo.entidad.Persona;

@org.springframework.stereotype.Repository
public interface PersonaRepository extends CrudRepository<Persona,Long>{
	
}
