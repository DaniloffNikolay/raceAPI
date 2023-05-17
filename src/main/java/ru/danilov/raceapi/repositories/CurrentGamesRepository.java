package ru.danilov.raceapi.repositories;

import ru.danilov.raceapi.models.CurrentGame;
import ru.danilov.raceapi.models.Person;

public interface CurrentGamesRepository {

    CurrentGame getCurrentGameByPerson(Person person);
}
