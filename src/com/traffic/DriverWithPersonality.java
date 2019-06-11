package com.traffic;

public abstract class DriverWithPersonality implements Driver{
    protected Personality personality;

    public DriverWithPersonality() {
        personality = new DefaultPersonality();
        }

    public void passedField() {
        personality.passedField();
    }
    public void passedIntersection() {
        personality.passedIntersection();
    }
    public void trafficJammed() {
        personality.trafficJammed();
    }
    public float getAngerLevel() {
        return personality.getAngerLevel();
    }

    public boolean isAngry() {
        return personality.isAngry();
    }

    public boolean drive() { return personality.drive(); }

    public boolean isAlive() {
        return true;
    }
}
