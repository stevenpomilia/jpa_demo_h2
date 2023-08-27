package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VirtualPetController {
    @Autowired
    VirtualPetRepository petRepository;

    @GetMapping("/api/pets/{id}")
    public ResponseEntity<VirtualPet> getPet(@PathVariable("id") long id) {
        Optional<VirtualPet> pet = petRepository.findById(id);

        if (pet.isPresent()) {
            return new ResponseEntity<>(pet.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/api/pets/")
    public ResponseEntity<List<VirtualPet>> getAllPets() {
        List<VirtualPet> pets = petRepository.findAll();

        if (pets.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<List<VirtualPet>>(pets, HttpStatus.OK);
        }
    }

    @PostMapping("/api/pets/add")
    public ResponseEntity<VirtualPet> createPet(@RequestBody VirtualPet pet) {
        VirtualPet newPet = petRepository
                .save(new VirtualPet(pet.getName(), pet.getDescription(), pet.getHunger(), pet.getThirst(),
                        pet.getBoredom()));
        return new ResponseEntity<>(newPet, HttpStatus.CREATED);
    }

    @DeleteMapping("/api/pets/delete/{id}")
    public ResponseEntity<HttpStatus> deletePet(@PathVariable Long id) {
        try {
            petRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
