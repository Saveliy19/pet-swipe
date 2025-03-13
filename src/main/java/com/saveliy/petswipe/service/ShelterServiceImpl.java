package com.saveliy.petswipe.service;

import com.saveliy.petswipe.dto.CreateShelterDTO;
import com.saveliy.petswipe.dto.ShelterDTO;
import com.saveliy.petswipe.entity.Shelter;
import com.saveliy.petswipe.exception.ResourceAlreadyExistsException;
import com.saveliy.petswipe.exception.ResourceDoesntExistsException;
import com.saveliy.petswipe.mapper.ShelterMapper;
import com.saveliy.petswipe.repository.ShelterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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
                .map(shelter -> new ShelterDTO(
                        shelter.getId(),
                        shelter.getWebsite(),
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
            shelterRepository.save(shelter);
            return ShelterMapper.INSTANCE.ShelterToShelterDTO(shelter);
        } catch (DataIntegrityViolationException e){
            throw new ResourceAlreadyExistsException("This shelter already exists");
        }
    }

    @Override
    @Transactional
    public ShelterDTO getShelter(int id) {
        try {
            return ShelterMapper.INSTANCE.ShelterToShelterDTO(shelterRepository.findById(id).get());
        } catch (NoSuchElementException e){
            throw new ResourceDoesntExistsException("Shelter with id " + id + " does not exist");
        }
    }

    @Override
    @Transactional
    public void deleteShelter(int id) {
        Optional<Shelter> shelter = shelterRepository.findById(id);
        if (shelter.isPresent()) { shelterRepository.deleteById(id);
        } else { throw new ResourceDoesntExistsException("Shelter with id " + id + " not found"); }
    }

    @Override
    @Transactional
    public ShelterDTO updateShelter(int id, CreateShelterDTO shelterDTO) {
        Shelter shelter = shelterRepository
                .findById(id)
                .orElseThrow(() -> new ResourceDoesntExistsException("Shelter with id " + id + " does not exist"));
        ShelterMapper.INSTANCE.updateShelterFromCreateShelterDto(shelterDTO, shelter);
        shelterRepository.save(shelter);
        return ShelterMapper.INSTANCE.ShelterToShelterDTO(shelter);
    }
}
