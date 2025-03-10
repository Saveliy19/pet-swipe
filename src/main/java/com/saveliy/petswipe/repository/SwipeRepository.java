package com.saveliy.petswipe.repository;

import com.saveliy.petswipe.entity.Swipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SwipeRepository extends JpaRepository<Swipe, Integer> {
}
