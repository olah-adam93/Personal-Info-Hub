package com.example.PersonalInfoManager.mapper;

import com.example.PersonalInfoManager.model.DTO.CreatePersonDTO;
import com.example.PersonalInfoManager.model.DTO.PersonDTO;
import com.example.PersonalInfoManager.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = AddressMapper.class)
public interface PersonMapper {

  PersonDTO toDto(Person person);

  Person toEntity(CreatePersonDTO personDTO);

  void updatePersonFromDTO(CreatePersonDTO personDTO, @MappingTarget Person person);
}
