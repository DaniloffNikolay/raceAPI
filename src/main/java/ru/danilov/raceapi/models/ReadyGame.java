package ru.danilov.raceapi.models;

public class ReadyGame {
    private long id;
    private String namePlayerOne;

    public ReadyGame() {
    }

    public ReadyGame(CurrentGame currentGame) {
        this.id = currentGame.getId();
        this.namePlayerOne = currentGame.getPeronOne().getName();
    }

    public ReadyGame(long id, String namePlayerOne) {
        this.id = id;
        this.namePlayerOne = namePlayerOne;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNamePlayerOne() {
        return namePlayerOne;
    }

    public void setNamePlayerOne(String namePlayerOne) {
        this.namePlayerOne = namePlayerOne;
    }
}
