package ru.netology.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.netology.hibernate.entity.Person;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    @Query("select p from Person p where p.cityOfLiving = :city")
    List<Person> findByCityOfLiving(String city);

    @Query("select p from Person p where p.age < :age order by p.age asc")
    List<Person> findByAgeLessThanOrderByAgeAsc(Integer age);

    @Query("select p from Person p where p.name = :name and p.surname = :surname")
    Optional<Person> findByNameAndSurname(String name, String surname);
}
