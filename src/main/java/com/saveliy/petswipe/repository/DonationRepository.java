package com.saveliy.petswipe.repository;

import com.saveliy.petswipe.entity.Donation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationRepository extends JpaRepository<Donation, Integer> {
}
