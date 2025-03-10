package com.saveliy.petswipe.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "pet_details")
public class PetDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "breed")
    private String breed;

    @Column(name = "special_needs")
    private String specialNeeds;

    public PetDetail() {}

    public PetDetail(String breed, String specialNeeds) {
        this.breed = breed;
        this.specialNeeds = specialNeeds;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getSpecialNeeds() {
        return specialNeeds;
    }

    public void setSpecialNeeds(String specialNeeds) {
        this.specialNeeds = specialNeeds;
    }
}
