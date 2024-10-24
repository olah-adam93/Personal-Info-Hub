package com.example.PersonalInfoManager.service;

import com.example.PersonalInfoManager.exception.PersonNotFoundException;
import com.example.PersonalInfoManager.mapper.PersonMapper;
import com.example.PersonalInfoManager.model.DTO.CreatePersonDTO;
import com.example.PersonalInfoManager.model.DTO.PersonDTO;
import com.example.PersonalInfoManager.model.Person;
import com.example.PersonalInfoManager.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    public PersonServiceImpl(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    public PersonDTO createPerson(CreatePersonDTO personDTO) {
        Person person = personMapper.toEntity(personDTO);
        person = personRepository.save(person);
        return personMapper.toDto(person);
    }

    public List<PersonDTO> getAllPersons() {
        return personRepository.findAll().stream()
                .map(personMapper::toDto)
                .collect(Collectors.toList());
    }

    public PersonDTO getPersonById(Long id) {
        Optional<Person> person = personRepository.findById(id);
    return person
        .map(personMapper::toDto)
        .orElseThrow(() -> new PersonNotFoundException("Person not found with ID: " + id));
    }

    public PersonDTO updatePerson(Long id, CreatePersonDTO personDTO) {
    Person existingPerson =
        personRepository
            .findById(id)
            .orElseThrow(() -> new PersonNotFoundException("Person not found with ID: " + id));

        personMapper.updatePersonFromDTO(personDTO, existingPerson);

        Person updatedPerson = personRepository.save(existingPerson);
        return personMapper.toDto(updatedPerson);
    }

    public void deletePerson(Long id) {
        if (!personRepository.existsById(id)) {
            throw new PersonNotFoundException("Person not found with ID: " + id);
        }
        personRepository.deleteById(id);
    }
}


