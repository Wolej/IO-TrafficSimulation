package com.traffic;

public class DefaultPersonality implements Personality {

    private Anger anger;

    @Override
    public void passedField() {
        anger.lowerAnger(1);
    }

    @Override
    public void passedIntersection() {
        anger.lowerAnger(10);
    }

    @Override
    public void trafficJammed() {
        anger.raiseAnger(2);
    }

    @Override
    public Anger getAngerLevel() {
        return anger;
    }

    public boolean isAngry() {
        return anger.isAngry();
    }
}
