package com.traffic;

import java.util.Random;

public class DefaultPersonality implements Personality {
    private int lag = 0;
    private Anger anger;
    private Random rng;

    public DefaultPersonality() {
        anger = new Anger(new Statistics());
        rng = new Random();
    }

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
        lag = Math.max(lag, rng.nextInt(10));
    }

    @Override
    public float getAngerLevel() {
        return anger.getAngerLevel();
    }

    public boolean isAngry() {
        return anger.isAngry();
    }

    public boolean drive() {
        if (lag == 0) return true;
        lag--;
        return false;
    }
}
