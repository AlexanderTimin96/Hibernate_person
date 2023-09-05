package ru.netology.hibernate.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.netology.hibernate.entity.Person;

import java.util.List;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    @PersistenceContext
    private EntityManager entityMeneger;

    @Override
    public List<Person> findPersonByCity(String city) {
        var result = entityMeneger.createNativeQuery("select * from persons where city_of_living = :city")
                .setParameter("city", city);
        return result.getResultList();
    }
}
