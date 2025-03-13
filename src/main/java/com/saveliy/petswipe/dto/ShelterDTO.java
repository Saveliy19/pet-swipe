package com.saveliy.petswipe.dto;

public record ShelterDTO(String website, String description,
                         String location, String email, String name) {
    public ShelterDTO() {
        this(null, null, null, null, null);
    }
}
