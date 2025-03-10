package com.saveliy.petswipe.repository;

import com.saveliy.petswipe.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
