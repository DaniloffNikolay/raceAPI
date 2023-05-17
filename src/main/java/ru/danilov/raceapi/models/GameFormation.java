package ru.danilov.raceapi.models;

public class GameFormation {
    private long id;
    private int size;
    private Person creator;

    public GameFormation() {
    }

    public GameFormation(int id, int size, Person creator) {
        this.id = id;
        this.size = size;
        this.creator = creator;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Person getCreator() {
        return creator;
    }

    public void setCreator(Person creator) {
        this.creator = creator;
    }
}
