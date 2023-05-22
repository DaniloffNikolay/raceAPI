package ru.danilov.raceapi.dto;

public class StepDataDTO {
    private byte direction;
    private boolean isBoost;
    private boolean isBrake;

    public StepDataDTO() {
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
