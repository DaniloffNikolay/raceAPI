package ru.danilov.raceapi.repositories.implementation;

import engine.Game;
import engine.Player;
import engine.field.Field;
import org.springframework.stereotype.Component;
import ru.danilov.raceapi.models.CurrentGame;
import ru.danilov.raceapi.models.Person;
import ru.danilov.raceapi.repositories.CurrentGamesRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class ImplCurrentGamesRepository implements CurrentGamesRepository {

    private static final List<CurrentGame> games = new ArrayList<>();

    private static long count = 1;

    @Override
    public CurrentGame getCurrentGameByPerson(Person person) {
        for (CurrentGame currentGame : games) {
            if (currentGame.getPeronOne() == person || currentGame.getPeronTwo() == person)
                return currentGame;
        }

        return null;
    }

    @Override
    public CurrentGame createNewCurrentGame(Person person) {
        Player playerOne = new Player(person.getName());
        Player playerTwo = new Player(null);
        Game game = new Game(Field.getInstance(10), playerOne, playerTwo);

        CurrentGame currentGame = new CurrentGame(count, game, person, null);
        count++;

        games.add(currentGame);

        return currentGame;
    }

    @Override
    public CurrentGame setPersonTwo(CurrentGame currentGame, Person person) {

        for (CurrentGame game : games) {
            if (game == currentGame) {
                game.setPeronTwo(person);
                return game;
            }
        }

        return null;
    }

    @Override
    public List<CurrentGame> getAllReadyGames() {
        List<CurrentGame> result = new ArrayList<>();

        for (CurrentGame currentGame : games) {
            if (currentGame.getPeronTwo() == null)
                result.add(currentGame);
        }

        return result;
    }

    @Override
    public List<CurrentGame> getAllGames() {
        return games;
    }

    public static long getCount() {
        return count;
    }
}
