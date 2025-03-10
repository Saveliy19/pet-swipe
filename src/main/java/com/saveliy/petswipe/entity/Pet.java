package com.saveliy.petswipe.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "pets")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "available")
    private boolean available;

    public Shelter getShelter() {
        return shelter;
    }

    public void setShelter(Shelter shelter) {
        this.shelter = shelter;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pet_id")
    private PetDetail petDetail;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Shelter shelter;

    @OneToMany(mappedBy = "pet")
    private List<Swipe> swipes;

    public PetDetail getPetDetail() {
        return petDetail;
    }

    public void setPetDetail(PetDetail petDetail) {
        this.petDetail = petDetail;
    }

    public List<Swipe> getSwipes() {
        return swipes;
    }

    public void setSwipes(List<Swipe> swipes) {
        this.swipes = swipes;
    }

    public Pet() {}

    public Pet(String name, String type, boolean available) {
        this.name = name;
        this.type = type;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
