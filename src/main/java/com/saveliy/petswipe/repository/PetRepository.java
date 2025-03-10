package com.saveliy.petswipe.repository;

import com.saveliy.petswipe.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Integer> {
}
