package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LoadDatabase {

	public static void main(String[] args) {
		SpringApplication.run(LoadDatabase.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(VirtualPetRepository petRepository) {
		return arg -> {
			// optionally use in addition to or in place of data.sql seeding
			VirtualPet scout = new VirtualPet("Scout", "Mini Australian Shepherd", 50, 40, 30);
			petRepository.save(scout);

			VirtualPet myla = new VirtualPet("Myla", "Purebred Australian Shepherd", 60, 50, 40);
			petRepository.save(myla);

			VirtualPet honey = new VirtualPet("Honey", "Purebred Golden Doodle", 70, 60, 50);
			petRepository.save(honey);

			VirtualPet zigzag = new VirtualPet("Zig-Zag", "Long-haired Tabby", 50, 60, 50);
			petRepository.save(zigzag);

			VirtualPet gizmo = new VirtualPet("Gizmo", "Short-haired Grey Kitty", 40, 40, 70);
			petRepository.save(gizmo);

			// Q: see if you can figure out how to create Order records, next....
			// orders table (not "order" table because that word is a reserved SQL keyword)
			// unique id (VARCHAR)
			// foreign key to the customer record
			// shipped_location column for where the order gets sent to (VARCHAR)
			// purchase_total for how much the customer spent (VARCHAR)
			// establish the "relationship" between customer table and orders table e.g.
			// @OneToMany @ManyToOne
		};
	}

}
