package com.learning.movie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MoviesApplication {
	 static final Logger log =    LoggerFactory.getLogger(MoviesApplication.class);
	public static void main(String[] args) {
		log.info("======================================Before Starting application===================");
		SpringApplication.run(MoviesApplication.class, args);
	}

}
