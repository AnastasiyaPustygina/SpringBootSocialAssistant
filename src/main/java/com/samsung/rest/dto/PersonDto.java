package com.samsung.rest.dto;

import com.samsung.domain.Person;
import liquibase.pro.packaged.S;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class PersonDto {
    private int id;
    private String name, telephone, email, city, photo, date_of_birth;
    private int age;
    private String password;
    public static PersonDto toDto(Person person){
        return new PersonDto(person.getId(), person.getName(), person.getTelephone(),
                person.getEmail(), person.getCity(), person.getPhoto(), person.getDate_of_birth(),
                person.getAge(), person.getPassword());
    }
    public static Person toDomainObject(PersonDto personDto){

        return new Person(personDto.getId(), personDto.getName(), personDto.getTelephone(),
                personDto.getEmail(), personDto.getCity(), personDto.getPhoto(),
                personDto.getDate_of_birth(), personDto.getAge(), personDto.getPassword());
    }


}
