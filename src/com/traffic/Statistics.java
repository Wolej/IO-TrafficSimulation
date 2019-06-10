package com.traffic;

public class Statistics {
    private double angerLevel;  // exponential avg
    private double waitingTime;

    public Statistics() {
        angerLevel = 0.0;
        waitingTime = 0.0;
    }

    void updateWaitingTime(double wtime) {
        waitingTime = 0.9*waitingTime + 0.1*wtime;
    }

    void updateAngerLevel(int newAnger) {
        angerLevel = 0.9*angerLevel + 0.1*newAnger;
    }

    double getAngerLevel() {
        return angerLevel;
    }

    double getWaitingTime() {return waitingTime; }

}
