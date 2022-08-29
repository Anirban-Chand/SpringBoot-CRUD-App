package com.example.firstproject.api;

import com.example.firstproject.model.Person;
import com.example.firstproject.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@Valid @RequestBody Person person) {
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPerson() {
        return personService.getAllPersons();
    }

    @GetMapping(path = "{id}")
    public Optional<Person> getPersonById(@PathVariable("id") UUID id) {
        return personService.getPersonById(id);
    }

    @DeleteMapping(path = "{id}")
    public int deletePerson(@PathVariable("id") UUID id) {
        return personService.deletePerson(id);
    }

    @PutMapping("{id}")
    public int updatePerson(@PathVariable("id") UUID id,
                            @Valid @RequestBody Person updatedPerson) {
        return personService.updatePerson(id, updatedPerson);
    }
}
