package com.samsung.service;

import com.samsung.domain.Organization;
import com.samsung.domain.Person;
import com.samsung.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService{

    private final PersonRepository personRepository;

    @Override
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @Override
    public Person insert(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person getById(int id) {
        return personRepository.getById(id);
    }

    @Override
    public Person update(Person person) {;
        return personRepository.save(person);
    }

    @Override
    public void deleteById(int id) {
        personRepository.deleteById(id);
    }
}
