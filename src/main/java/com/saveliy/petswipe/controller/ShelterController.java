package com.saveliy.petswipe.controller;

import com.saveliy.petswipe.dto.CreateShelterDTO;
import com.saveliy.petswipe.dto.ShelterDTO;
import com.saveliy.petswipe.service.ShelterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shelters")
public class ShelterController {

    private final ShelterService shelterService;

    @Autowired
    public ShelterController(ShelterService shelterService) {
        this.shelterService = shelterService;
    }

    @GetMapping
    public List<ShelterDTO> getShelters() {
        return shelterService.getShelters();
    }

    @PostMapping
    public ShelterDTO addShelter(@RequestBody CreateShelterDTO shelterDTO) {
        return shelterService.addShelter(shelterDTO);
    }
}
