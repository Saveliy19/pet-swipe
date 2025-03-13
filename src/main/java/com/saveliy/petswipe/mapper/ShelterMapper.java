package com.saveliy.petswipe.mapper;

import com.saveliy.petswipe.dto.CreateShelterDTO;
import com.saveliy.petswipe.dto.ShelterDTO;
import com.saveliy.petswipe.entity.Shelter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ShelterMapper {
    ShelterMapper INSTANCE = Mappers.getMapper(ShelterMapper.class);

    Shelter CreateShelterDTOToShelter(CreateShelterDTO shelterDTO);
    ShelterDTO ShelterToShelterDTO(Shelter shelter);

    @Mapping(target = "id", ignore = true)
    void updateShelterFromCreateShelterDto(CreateShelterDTO shelterDTO, @MappingTarget Shelter shelter);
}
