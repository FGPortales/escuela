package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.Repository;

import com.example.demo.entidad.Compania;

@org.springframework.stereotype.Repository
public interface CompaniaRepository extends CrudRepository<Compania,Long>{
	
}
