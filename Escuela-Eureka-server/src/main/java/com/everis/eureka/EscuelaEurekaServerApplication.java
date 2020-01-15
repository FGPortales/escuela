package com.everis.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@EnableEurekaServer
@SpringBootApplication
public class EscuelaEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EscuelaEurekaServerApplication.class, args);
	}

}
