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
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository, OrderRepository orderRepository) {
		return arg -> {
			// optionally use in addition to or in place of data.sql seeding
			Customer john = new Customer("John", "Alexander", "07/28/2023");
			customerRepository.save(john);

			Customer jenny = new Customer("Jenny", "Smith", "07/28/2023");
			customerRepository.save(jenny);

			// Q: see if you can figure out how to create Order records, next....
			// orders table (not "order" table because that word is a reserved SQL keyword)
			// unique id (VARCHAR)
			// foreign key to the customer record
			// shipped_location column for where the order gets sent to (VARCHAR)
			// purchase_total for how much the customer spent (VARCHAR)
			// establish the "relationship" between customer table and orders table e.g. @OneToMany @ManyToOne

			Order forJohn = new Order(john, "Charleston 29408", "$100.00");
			orderRepository.save(forJohn);

			Order forJenny = new Order(jenny, "North Charleston 29406", "$110.00");
			orderRepository.save(forJenny);
		};
	}


}
