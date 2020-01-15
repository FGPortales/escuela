package com.example.demo.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ValidationDniException extends Exception {


	private static final long serialVersionUID = 1L;
	private String message;	


	
}
