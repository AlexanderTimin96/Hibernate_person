package ru.netology.hibernate.controller;

import jakarta.annotation.security.RolesAllowed;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.hibernate.entity.Person;
import ru.netology.hibernate.repository.PersonRepository;

import java.util.List;

@RestController
@RequestMapping("security/persons")
@AllArgsConstructor
public class SecurityPersons {
    private final PersonRepository personRepository;


    @GetMapping("/by-city")
    @PreAuthorize("hasAnyRole('ROLE_WRITE', 'ROLE_DELETE')")
    private List<Person> findPersonsByCity(@RequestParam String city) {
        return personRepository.findByCityOfLiving(city);
    }

    @GetMapping("/by-age")
    @RolesAllowed("{ROLE_WRITE}")
    private List<Person> findPersonsByAgeAndSort(@RequestParam String age) {
        return personRepository.findByAgeLessThanOrderByAgeAsc(Integer.valueOf(age));
    }


    @PreAuthorize("#username == authentication.principal.username")
    @GetMapping("/hello")
    public String hello(@RequestParam String username) {
        return "Hello " + username;
    }


    @GetMapping("/hi")
    public String hello() {
        return "hi from security ";
    }
}
