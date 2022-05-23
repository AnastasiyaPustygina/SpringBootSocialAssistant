package com.samsung.service;

import com.samsung.domain.Person;

import java.util.List;

public interface PersonService {
    Person insert(Person person);
    Person getById(int id);
    Person update(int id, String name, String telephone, String email, String city, String photo,
                  String date_of_birth, int age);
    void deleteById(int id);
}
