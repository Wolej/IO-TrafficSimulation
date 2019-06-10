package com.traffic;


import static java.lang.Math.*;

public class Anger {    //Driver is considered angry if anger >= 100, anger is always <= 200
    private static final int ANGERTRESHOLD = 100;
    private static final int MAXANGER = 200;
    private static final int MINANGER = 0;

    private int anger;

    public Anger() {
        anger = 0;
    }

    public Anger(int a) {
        anger = min(MAXANGER, a);
        anger = max(MINANGER, a);
    }

    public void raiseAnger(int a) {
        anger = min(MAXANGER, anger + a);
    }

    public void lowerAnger(int a) {
        anger = max(MINANGER, anger - a);
    }

    public boolean isAngry() {
        return anger >= ANGERTRESHOLD;
    }

    public float getAngerLevel() {
        return (float) anger / MAXANGER;
    }
}
