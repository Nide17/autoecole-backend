package com.autoecole.springboot.autoecolebackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication // THIS TELLS THE COMPILER THAT THIS IS A SPRING BOOT APPLICATION
@RestController // This is a REST controller
public class Main {

	public static void main(String[] args) { // THIS IS THE MAIN METHOD
		SpringApplication.run(Main.class, args); // THIS IS THE ENTRY POINT OF THE APPLICATION - RUN THE APPLICATION
	}

	@GetMapping("/") // THIS IS THE ROOT URL
	public String home() { // THIS IS THE HOME METHOD
		return "Hello World!";
	}
}
