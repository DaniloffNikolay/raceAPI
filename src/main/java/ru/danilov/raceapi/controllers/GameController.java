package ru.danilov.raceapi.controllers;

import engine.Player;
import engine.Game;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.danilov.raceapi.RaceApiApplication;
import ru.danilov.raceapi.models.CurrentGame;
import ru.danilov.raceapi.models.Person;
import ru.danilov.raceapi.services.CurrentGamesService;
import ru.danilov.raceapi.util.Utils;

@RestController
@RequestMapping("/game")
public class GameController {
    private static final Logger log = LoggerFactory.getLogger(RaceApiApplication.class);

    private final CurrentGamesService currentGamesService;

    @Autowired
    public GameController(CurrentGamesService currentGamesService) {
        this.currentGamesService = currentGamesService;
    }

    @GetMapping()
    public ResponseEntity<Player> getPlayer() {
        log.info("GET: /game");

        //получаем текущего пользователя
        Person person = Utils.getAuthPerson();


        CurrentGame currentGame = currentGamesService.getGame(person);

        Player player = null;

        if (person.equals(currentGame.getPeronOne())) {
            player = currentGame.getGame().getPlayerOne();
        } else if (person.equals(currentGame.getPeronTwo())) {
            player = currentGame.getGame().getPlayerTwo();
        } else {
            System.err.println("ERROR");
        }

        return ResponseEntity.status(HttpStatus.OK).body(player);
    }

    @GetMapping("/full")
    public ResponseEntity<Game> getGame() {
        log.info("GET: /game/full");

        //получаем текущего пользователя
        Person person = Utils.getAuthPerson();

        CurrentGame currentGame = currentGamesService.getGame(person);

        return ResponseEntity.status(HttpStatus.OK).body(currentGame.getGame());
    }
}
