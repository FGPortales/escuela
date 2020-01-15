package com.example.demo.handler;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorDetails {
	private Date fecha; 
	private String mensaje;
	private String details;

}

