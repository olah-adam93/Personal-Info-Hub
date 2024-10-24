package com.example.PersonalInfoManager.controller;

import com.example.PersonalInfoManager.model.DTO.CreatePersonDTO;
import com.example.PersonalInfoManager.model.DTO.PersonDTO;
import com.example.PersonalInfoManager.service.PersonService;
import java.util.List;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    /**
     * Create a new person.
     * @param personDTO Data of the person to create.
     * @return Created person's details.
     */
    @PostMapping
    public ResponseEntity<PersonDTO> createPerson(@Valid @RequestBody CreatePersonDTO personDTO) {
        PersonDTO createdPerson = personService.createPerson(personDTO);
        return new ResponseEntity<>(createdPerson, HttpStatus.CREATED);
    }

    /**
     * Retrieve all persons.
     * @return List of all persons.
     */
    @GetMapping
    public ResponseEntity<List<PersonDTO>> getAllPersons() {
        List<PersonDTO> persons = personService.getAllPersons();
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    /**
     * Retrieve a person by ID.
     * @param id ID of the person.
     * @return Details of the person.
     */
    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> getPersonById(@PathVariable Long id) {
        PersonDTO person = personService.getPersonById(id);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    /**
     * Update an existing person by ID.
     * @param id ID of the person to update.
     * @param personDTO Updated data of the person.
     * @return Updated person's details.
     */
    @PutMapping("/{id}")
    public ResponseEntity<PersonDTO> updatePerson(@PathVariable Long id, @Valid @RequestBody CreatePersonDTO personDTO) {
        PersonDTO updatedPerson = personService.updatePerson(id, personDTO);
        return new ResponseEntity<>(updatedPerson, HttpStatus.OK);
    }

    /**
     * Delete a person by ID.
     * @param id ID of the person to delete.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


