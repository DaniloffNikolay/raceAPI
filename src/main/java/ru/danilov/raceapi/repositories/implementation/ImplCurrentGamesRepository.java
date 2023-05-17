package ru.danilov.raceapi.repositories.implementation;

import org.springframework.stereotype.Component;
import ru.danilov.raceapi.models.CurrentGame;
import ru.danilov.raceapi.models.Person;
import ru.danilov.raceapi.repositories.CurrentGamesRepository;
import ru.danilov.raceapi.util.Utils;

@Component
public class ImplCurrentGamesRepository implements CurrentGamesRepository {

    @Override
    public CurrentGame getCurrentGameByPerson(Person person) {
        return Utils.getCurrentGame();
    }
}
