package ru.danilov.raceapi.util;

import engine.Game;
import engine.Player;
import engine.field.Field;
import ru.danilov.raceapi.models.CurrentGame;
import ru.danilov.raceapi.models.Person;

public class Utils {

    /*private static Person personOne = new Person(1, "Player one", null);
    private static Person personTwo = new Person(2, "Player two", null);

    private static CurrentGame currentGame;
    private static Game game;

    private static int count = 0;


    public static Person getAuthPerson() {
        count++;
        if (count % 2 != 0)
            return personOne;
        else
            return personTwo;
    }

    public static CurrentGame getCurrentGame() {
        if (currentGame == null) {
            currentGame = new CurrentGame(getGame(), personOne, personTwo);

            personOne.setCurrentGame(currentGame);
            personTwo.setCurrentGame(currentGame);
        }

        return currentGame;
    }

    private static Game getGame() {
        if (game == null) {
            Player playerOne = new Player(personOne.getName());
            Player playerTwo = new Player(personTwo.getName());
            game = new Game(Field.getInstance(10), playerOne, playerTwo);
        }

        return game;
    }*/
}
