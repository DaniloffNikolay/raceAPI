package ru.danilov.raceapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.danilov.raceapi.models.CurrentGame;
import ru.danilov.raceapi.models.Person;
import ru.danilov.raceapi.repositories.CurrentGamesRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CurrentGamesService {

    private final CurrentGamesRepository currentGamesRepository;

    @Autowired
    public CurrentGamesService(CurrentGamesRepository currentGamesRepository) {
        this.currentGamesRepository = currentGamesRepository;
    }

    public CurrentGame getGame(Person person) {
        return currentGamesRepository.getCurrentGameByPerson(person);
    }

    public CurrentGame createNewCurrentGame(Person person) {
        return currentGamesRepository.createNewCurrentGame(person);
    }

    public CurrentGame setPersonTwo(CurrentGame currentGame, Person person) {
        return currentGamesRepository.setPersonTwo(currentGame, person);
    }

    public List<CurrentGame> getAllReadyGames() {
        return currentGamesRepository.getAllReadyGames();
    }

    public List<CurrentGame> getAllGames() {
        return currentGamesRepository.getAllGames();
    }
}
