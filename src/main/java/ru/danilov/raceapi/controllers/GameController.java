package ru.danilov.raceapi.controllers;

import engine.Player;
import engine.Game;
import engine.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.danilov.raceapi.dto.StepDataDTO;
import ru.danilov.raceapi.RaceApiApplication;
import ru.danilov.raceapi.models.CurrentGame;
import ru.danilov.raceapi.models.Person;
import ru.danilov.raceapi.models.ReadyGame;
import ru.danilov.raceapi.security.PersonDetails;
import ru.danilov.raceapi.services.CurrentGamesService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();

        Person person = personDetails.getPerson();
        person.setPassword(null);

        log.info("GET: /game");

        CurrentGame currentGame = currentGamesService.getGame(person);

        if (currentGame == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }

        Player player = null;

        if (person.equals(currentGame.getPeronOne())) {
            player = currentGame.getGame().getPlayerOne();
        } else if (person.equals(currentGame.getPeronTwo())) {
            player = currentGame.getGame().getPlayerTwo();
        } else {
            log.info("error! Not found player!!!!!!!!!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(player);
    }

    @GetMapping("/full")
    public ResponseEntity<Game> getGame() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();

        Person person = personDetails.getPerson();
        person.setPassword(null);

        log.info("GET: /game/full");

        CurrentGame currentGame = currentGamesService.getGame(person);

        if (currentGame == null)
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);

        return ResponseEntity.status(HttpStatus.OK).body(currentGame.getGame());
    }

    @PostMapping("/step")
    public ResponseEntity<Player> doStep(@RequestBody @Valid StepDataDTO stepDataDTO,
                                         BindingResult bindingResult) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();

        Person person = personDetails.getPerson();
        person.setPassword(null);

        log.info("GET: /game/step");

        if (bindingResult.hasErrors()) {
            //TODO
        }

        CurrentGame currentGame = currentGamesService.getGame(person);

        Player player = null;

        if (person.equals(currentGame.getPeronOne())) {
            player = currentGame.getGame().getPlayerOne();
        } else if (person.equals(currentGame.getPeronTwo())) {
            player = currentGame.getGame().getPlayerTwo();
        } else {
            log.info("error! Not found player!!!!!!!!!");
        }

        if (currentGame.getGame().whoIsNext() != player) {
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(player);
        }

        Step step = new Step(player, stepDataDTO.getDirection(), stepDataDTO.isBoost(), stepDataDTO.isBrake());
        currentGame.getGame().action(step);

        return ResponseEntity.status(HttpStatus.OK).body(player);
    }

    @PostMapping("/create")
    public ResponseEntity<ReadyGame> createGame() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();

        Person person = personDetails.getPerson();
        person.setPassword(null);

        log.info("GET: /game/create");

        CurrentGame currentGame = currentGamesService.createNewCurrentGame(person);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ReadyGame(currentGame));
    }

    @GetMapping("/list-ready")
    public ResponseEntity<List<ReadyGame>> getReadyGames() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();

        Person person = personDetails.getPerson();
        person.setPassword(null);

        log.info("GET: /game/list-ready");

        List<CurrentGame> currentGames = currentGamesService.getAllReadyGames();

        List<ReadyGame> readyGames = new ArrayList<>();

        for (CurrentGame currentGame : currentGames) {
            readyGames.add(new ReadyGame(currentGame.getId(), currentGame.getPeronOne().getName()));
        }

        return ResponseEntity.status(HttpStatus.OK).body(readyGames);
    }
}
