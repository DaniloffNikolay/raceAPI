package ru.danilov.raceapi.repositories;

import ru.danilov.raceapi.models.CurrentGame;
import ru.danilov.raceapi.models.Person;

import java.util.List;

public interface CurrentGamesRepository {

    CurrentGame getCurrentGameByPerson(Person person);

    CurrentGame createNewCurrentGame(Person person);

    CurrentGame setPersonTwo(CurrentGame currentGame, Person person);

    List<CurrentGame> getAllReadyGames();

    List<CurrentGame> getAllGames();
}
