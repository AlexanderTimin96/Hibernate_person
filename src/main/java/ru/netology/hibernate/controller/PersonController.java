package ru.netology.hibernate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.hibernate.entity.Person;
import ru.netology.hibernate.repository.PersonRepository;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {
    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @GetMapping("/hello")
    private String findPersonsByCity() {
        return "Hello";
    }


    @GetMapping("/by-city")
    private List<Person> findPersonsByCity(@RequestParam String city) {
        return personRepository.findByCityOfLiving(city);
    }

    @GetMapping("/by-age")
    private List<Person> findPersonsByAgeAndSort(@RequestParam String age) {
        return personRepository.findByAgeLessThanOrderByAgeAsc(Integer.valueOf(age));
    }

    @GetMapping("/by-name-and-surname")
    private Person findByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        var person = personRepository.findByNameAndSurname(name, surname);
        return person.orElse(null);
    }
}
