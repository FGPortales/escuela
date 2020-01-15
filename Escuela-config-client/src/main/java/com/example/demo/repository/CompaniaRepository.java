package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.entidad.Compania;
import com.example.demo.util.CustomRepository;

@Repository
public interface CompaniaRepository extends CustomRepository<Compania, Long> {
	
}
