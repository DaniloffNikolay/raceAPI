package ru.danilov.raceapi.models;

public class StepData {
    private long id;
    private byte direction;
    private boolean isBoost;
    private boolean isBrake;

    public StepData() {
    }

    public StepData(long id, byte direction, boolean isBoost, boolean isBrake) {
        this.id = id;
        this.direction = direction;
        this.isBoost = isBoost;
        this.isBrake = isBrake;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public byte getDirection() {
        return direction;
    }

    public void setDirection(byte direction) {
        this.direction = direction;
    }

    public boolean isBoost() {
        return isBoost;
    }

    public void setBoost(boolean boost) {
        isBoost = boost;
    }

    public boolean isBrake() {
        return isBrake;
    }

    public void setBrake(boolean brake) {
        isBrake = brake;
    }
}
