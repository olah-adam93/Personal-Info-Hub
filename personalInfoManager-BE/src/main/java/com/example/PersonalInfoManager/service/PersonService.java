package com.example.PersonalInfoManager.service;

import com.example.PersonalInfoManager.model.DTO.CreatePersonDTO;
import com.example.PersonalInfoManager.model.DTO.PersonDTO;

import java.util.List;

public interface PersonService {
    PersonDTO createPerson(CreatePersonDTO personDTO);

    List<PersonDTO> getAllPersons();

    PersonDTO getPersonById(Long id);

    PersonDTO updatePerson(Long id, CreatePersonDTO personDTO);

    void deletePerson(Long id);
}
