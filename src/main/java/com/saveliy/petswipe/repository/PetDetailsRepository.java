package com.saveliy.petswipe.repository;

import com.saveliy.petswipe.entity.PetDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetDetailsRepository extends JpaRepository<PetDetail, Integer> {
}
