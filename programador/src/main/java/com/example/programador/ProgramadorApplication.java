package com.example.programador;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;


@SpringBootApplication
@EntityScan(basePackageClasses = {ProgramadorApplication.class, Jsr310JpaConverters.class})
public class ProgramadorApplication {

	public static void main(String[] args) {
	    SpringApplication app = new SpringApplication(ProgramadorApplication.class);
	    app.setDefaultProperties(Collections
	      .singletonMap("server.port", "8083"));
	    app.run(args);
	}
	
	
}
