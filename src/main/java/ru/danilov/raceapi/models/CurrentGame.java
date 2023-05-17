package ru.danilov.raceapi.models;

import engine.Game;

public class CurrentGame {

    private int id;
    private Game game;
    private Person peronOne;
    private Person peronTwo;

    public CurrentGame() {
    }

    public CurrentGame(int id, Game game, Person peronOne, Person peronTwo) {
        this.id = id;
        this.game = game;
        this.peronOne = peronOne;
        this.peronTwo = peronTwo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Person getPeronOne() {
        return peronOne;
    }

    public void setPeronOne(Person peronOne) {
        this.peronOne = peronOne;
    }

    public Person getPeronTwo() {
        return peronTwo;
    }

    public void setPeronTwo(Person peronTwo) {
        this.peronTwo = peronTwo;
    }
}
