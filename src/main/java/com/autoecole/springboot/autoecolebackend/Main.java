package com.autoecole.springboot.autoecolebackend;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // THIS TELLS THE COMPILER THAT THIS IS A SPRING BOOT APPLICATION
public class Main {
	public static void main(String[] args) { // THIS IS THE MAIN METHOD
		SpringApplication.run(Main.class, args); // THIS IS THE ENTRY POINT OF THE APPLICATION - RUN THE APPLICATION
	}
}
