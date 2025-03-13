package com.saveliy.petswipe.service;

import com.saveliy.petswipe.dto.CreateShelterDTO;
import com.saveliy.petswipe.dto.ShelterDTO;
import com.saveliy.petswipe.exception.ResourceAlreadyExistsException;
import com.saveliy.petswipe.exception.ResourceDoesntExistsException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ShelterServiceImplTest {

    @Autowired
    private ShelterServiceImpl shelterService;

    private final CreateShelterDTO createShelterDTO = new CreateShelterDTO("10lap",
            "10lap@mail.com", "Emva", "google.com", "10lap_description");

    @Test
    void addShelter() {
        List<ShelterDTO> sheltersBefore = shelterService.getShelters();
        ShelterDTO savedShelter = shelterService.addShelter(createShelterDTO);

        List<ShelterDTO> sheltersAfterAdd = shelterService.getShelters();

        assertThrows(ResourceAlreadyExistsException.class, () -> {
            shelterService.addShelter(createShelterDTO);
        });

        assertNotNull(savedShelter);
        assertEquals(savedShelter.email(), createShelterDTO.email());
        assertEquals(savedShelter.website(), createShelterDTO.website());
        assertEquals(sheltersBefore.size() + 1, sheltersAfterAdd.size());
    }

    @Test
    void getShelters() {
        List<ShelterDTO> shelters = shelterService.getShelters();
        assertNotNull(shelters);
        assertFalse(shelters.isEmpty());

        ShelterDTO savedShelter = shelterService.addShelter(createShelterDTO);
        List<ShelterDTO> sheltersAfterAdd = shelterService.getShelters();

        assertEquals(shelters.size() + 1, sheltersAfterAdd.size());
    }

    @Test
    void getShelter() {
        ShelterDTO shelterDTO = shelterService.addShelter(createShelterDTO);
        ShelterDTO foundShelter = shelterService.getShelter(shelterDTO.id());
        assertEquals(shelterDTO.email(), foundShelter.email());
        assertEquals(shelterDTO.website(), foundShelter.website());
        assertEquals(shelterDTO.id(), foundShelter.id());
    }

    @Test
    void deleteShelter() {
        ShelterDTO shelterDTO = shelterService.addShelter(createShelterDTO);
        shelterService.deleteShelter(shelterDTO.id());
        assertThrows(ResourceDoesntExistsException.class, () -> shelterService.getShelter(shelterDTO.id()));
        assertThrows(ResourceDoesntExistsException.class, () -> shelterService.deleteShelter(shelterDTO.id()));
    }

    @Test
    void updateShelter() {
        ShelterDTO savedShelter = shelterService.addShelter(createShelterDTO);
        CreateShelterDTO updatedShelterDTO = new CreateShelterDTO(
                "Updated 10lap", "updated@mail.com", "New Address", "updated.com", "Updated description"
        );

        ShelterDTO updatedShelter = shelterService.updateShelter(savedShelter.id(), updatedShelterDTO);
        shelterService.deleteShelter(updatedShelter.id());

        assertThrows(ResourceDoesntExistsException.class, () -> shelterService
                .updateShelter(savedShelter.id(), updatedShelterDTO));


        assertNotNull(updatedShelter);
        assertEquals(updatedShelterDTO.name(), updatedShelter.name());
        assertEquals(updatedShelterDTO.email(), updatedShelter.email());
    }
}