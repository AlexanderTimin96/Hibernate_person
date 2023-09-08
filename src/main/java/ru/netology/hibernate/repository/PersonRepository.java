package ru.netology.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.netology.hibernate.entity.Person;

import java.util.List;
import java.util.Optional;

public interface PersonRepository  extends JpaRepository<Person, Long> {
    List<Person> findByCityOfLiving(String city);

    List<Person> findByAgeLessThanOrderByAgeAsc(Integer age);

    Optional<Person> findByNameAndSurname(String name, String surname);
}
