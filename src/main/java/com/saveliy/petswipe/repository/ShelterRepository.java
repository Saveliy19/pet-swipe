package com.saveliy.petswipe.repository;

import com.saveliy.petswipe.entity.Shelter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShelterRepository extends JpaRepository<Shelter, Integer> {
    boolean existsByEmail(String email);
}
