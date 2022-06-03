package com.samsung.service;

import com.samsung.domain.Person;

import java.util.List;

public interface PersonService {
    Person insert(Person person);
    Person getById(int id);
    List<Person> getAll();
    Person update(Person person);
    void deleteById(int id);
}
