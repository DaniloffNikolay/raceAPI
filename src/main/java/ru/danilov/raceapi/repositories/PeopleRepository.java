package ru.danilov.raceapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.danilov.raceapi.models.Person;

import java.util.Optional;

public interface PeopleRepository extends JpaRepository<Person, Integer> {
    Optional<Person> findByName(String name);
}
