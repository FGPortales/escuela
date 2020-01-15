package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.Repository;

import com.example.demo.entidad.Persona;
import com.example.demo.util.CustomRepository;

@org.springframework.stereotype.Repository
public interface PersonaRepository extends CustomRepository<Persona,Long>{
	
}
