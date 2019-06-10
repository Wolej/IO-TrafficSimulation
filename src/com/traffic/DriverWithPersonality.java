package com.traffic;

public abstract class DriverWithPersonality implements Driver{
    private Personality personality;

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
}
