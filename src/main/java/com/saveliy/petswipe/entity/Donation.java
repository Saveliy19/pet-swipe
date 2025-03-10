package com.saveliy.petswipe.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "donations")
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "amount")
    private double amount;

    @Column(name = "comission")
    private double comission;

    @Column(name = "daonated_at")
    private Timestamp daonated_at;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "shelter_id")
    private Shelter shelter;

    public Donation() {}

    public Donation(double amount, double comission, Timestamp daonated_at) {
        this.amount = amount;
        this.comission = comission;
        this.daonated_at = daonated_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getComission() {
        return comission;
    }

    public void setComission(double comission) {
        this.comission = comission;
    }

    public Timestamp getDaonated_at() {
        return daonated_at;
    }

    public void setDaonated_at(Timestamp daonated_at) {
        this.daonated_at = daonated_at;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Shelter getShelter() {
        return shelter;
    }

    public void setShelter(Shelter shelter) {
        this.shelter = shelter;
    }
}

