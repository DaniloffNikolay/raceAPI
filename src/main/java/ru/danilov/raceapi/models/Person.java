package ru.danilov.raceapi.models;

import java.util.List;

public class Person {
    private long id;
    private String name;
    private CurrentGame currentGame;

    public Person() {
    }

    public Person(int id, String name, CurrentGame currentGame) {
        this.id = id;
        this.name = name;
        this.currentGame = currentGame;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CurrentGame getCurrentGame() {
        return currentGame;
    }

    public void setCurrentGame(CurrentGame currentGame) {
        this.currentGame = currentGame;
    }
}
