package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VirtualPetRepository extends JpaRepository<VirtualPet, Long> {

}
