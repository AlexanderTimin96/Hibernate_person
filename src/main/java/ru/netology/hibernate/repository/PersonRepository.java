package ru.netology.hibernate.repository;

import ru.netology.hibernate.entity.Person;

import java.util.List;

public interface PersonRepository {
    List<Person> findPersonByCity(String city);
}
