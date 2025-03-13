package com.saveliy.petswipe.service;

import com.saveliy.petswipe.dto.CreateShelterDTO;
import com.saveliy.petswipe.dto.ShelterDTO;
import com.saveliy.petswipe.entity.Shelter;
import com.saveliy.petswipe.exception.ResourceAlreadyExistsException;
import com.saveliy.petswipe.mapper.ShelterMapper;
import com.saveliy.petswipe.repository.ShelterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ShelterServiceImpl implements ShelterService {

    private final ShelterRepository shelterRepository;

    @Autowired
    public ShelterServiceImpl(ShelterRepository shelterRepository) {
        this.shelterRepository = shelterRepository;
    }

    @Override
    @Transactional
    public List<ShelterDTO> getShelters() {
        return shelterRepository
                .findAll()
                .stream()
                .map(shelter -> new ShelterDTO(shelter.getWebsite(),
                        shelter.getDescription(),
                        shelter.getLocation(),
                        shelter.getEmail(),
                        shelter.getName()))
                .toList();
    }

    @Override
    @Transactional
    public ShelterDTO addShelter(CreateShelterDTO createShelterDTO) {
        Shelter shelter = ShelterMapper.INSTANCE.CreateShelterDTOToShelter(createShelterDTO);
        try {
            shelterRepository.saveAndFlush(shelter);
            return ShelterMapper.INSTANCE.ShelterToShelterDTO(shelter);
        } catch (DataIntegrityViolationException e){
            throw new ResourceAlreadyExistsException("This shelter already exists");
        }
    }
}
