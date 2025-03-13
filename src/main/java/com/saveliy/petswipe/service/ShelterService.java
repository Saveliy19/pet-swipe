package com.saveliy.petswipe.service;

import com.saveliy.petswipe.dto.CreateShelterDTO;
import com.saveliy.petswipe.dto.ShelterDTO;

import java.util.List;

public interface ShelterService {
    public List<ShelterDTO> getShelters();

    public ShelterDTO addShelter(CreateShelterDTO createShelterDTO);
}