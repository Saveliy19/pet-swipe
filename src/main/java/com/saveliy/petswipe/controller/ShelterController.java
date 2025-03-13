package com.saveliy.petswipe.controller;

import com.saveliy.petswipe.dto.CreateShelterDTO;
import com.saveliy.petswipe.dto.ShelterDTO;
import com.saveliy.petswipe.service.ShelterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public ResponseEntity<List<ShelterDTO>> getShelters() {
        return ResponseEntity.ok(shelterService.getShelters());
    }

    @PostMapping
    public ResponseEntity<ShelterDTO> addShelter(@RequestBody CreateShelterDTO shelterDTO) {
        ShelterDTO shelter = shelterService.addShelter(shelterDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(shelter.id())
                .toUri();
        return ResponseEntity.created(location).body(shelter);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShelterDTO> getShelter(@PathVariable int id) {
        return ResponseEntity.ok(shelterService.getShelter(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShelter(@PathVariable int id) {
        shelterService.deleteShelter(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ShelterDTO> updateShelter(@PathVariable int id
            , @RequestBody CreateShelterDTO shelterDTO) {
        return ResponseEntity.ok(shelterService.updateShelter(id, shelterDTO));
    }
}
