package com.samsung.rest.controller;


import com.samsung.domain.Person;
import com.samsung.rest.dto.OrganizationDto;
import com.samsung.rest.dto.PersonDto;
import com.samsung.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @GetMapping("/person") public List<PersonDto> getAllPerson(){
        return personService.getAll().stream().map(PersonDto::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/person")
    public PersonDto insertPerson(@RequestBody PersonDto personDto){
        Person person = personService.insert(PersonDto.toDomainObject(personDto));
        return PersonDto.toDto(person);
    }
    @PutMapping("/person/{id}")
    public PersonDto updatePerson(@RequestBody PersonDto personDto){
        Person person = personService.update(PersonDto.toDomainObject(personDto));

        return PersonDto.toDto(person);
    }
    @DeleteMapping("/person/{id}")
    public void deletePerson(@PathVariable int id){
        personService.deleteById(id);
    }
    @GetMapping("/person/{id}")
    public PersonDto getPersonById(@PathVariable int id){
        Person person = personService.getById(id);
        return PersonDto.toDto(person);
    }
}
