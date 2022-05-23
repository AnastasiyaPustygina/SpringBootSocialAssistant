package com.samsung.service;

import com.samsung.domain.Person;
import com.samsung.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService{

    private final PersonRepository personRepository;

    @Override
    public Person insert(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person getById(int id) {
        return personRepository.getById(id);
    }

    @Override
    public Person update(int id, String name, String telephone, String email, String city,
                         String photo, String date_of_birth, int age) {
        Person person = Person.builder().id(id).name(name).telephone(telephone).
                email(email).city(city).photo(photo).date_of_birth(date_of_birth).age(age).build();
        return personRepository.save(person);
    }

    @Override
    public void deleteById(int id) {
        personRepository.deleteById(id);
    }
}
