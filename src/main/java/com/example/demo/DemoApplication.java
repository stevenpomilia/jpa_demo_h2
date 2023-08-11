package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
		return arg -> {
			Customer john = new Customer("John", "Alexander", "07/28/2023", "8675309");
			customerRepository.save(john);

			Customer jenny = new Customer("Jenny", "Smith", "07/28/2023", "8675309");
			customerRepository.save(jenny);

			// Q: see if you can figure out how to create Order records, next....
		};
	}


}
