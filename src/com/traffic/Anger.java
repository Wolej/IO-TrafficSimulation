package com.traffic;


import static java.lang.Math.*;

public class Anger {    //Driver is considered angry if anger >= 100, anger is always <= 200
    private static final int ANGERTRESHOLD = 100;
    private static final int MAXANGER = 200;
    private static final int MINANGER = 0;

    private int anger;
    private Statistics stat;

    public Anger(Statistics stat) {
        anger = 0;
        this.stat = stat;
    }

    public Anger(int a, Statistics stat) {
        anger = min(MAXANGER, a);
        anger = max(MINANGER, a);
        this.stat = stat;
        stat.updateAngerLevel(anger);

    }

    public void raiseAnger(int a) {
        anger = min(MAXANGER, anger + a);
        stat.updateAngerLevel(anger);
    }

    public void lowerAnger(int a) {
        anger = max(MINANGER, anger - a);
        stat.updateAngerLevel(anger);
    }

    public boolean isAngry() {
        return anger >= ANGERTRESHOLD;
    }

    public float getAngerLevel() {
        return (float) anger / MAXANGER;
    }
}
