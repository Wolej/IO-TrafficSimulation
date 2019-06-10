package com.traffic;

public class EqIntersection extends Intersection {
    private int counter;
    private int cycleLength;

    public EqIntersection(int x, int y, int cycleLength) {
        super(x, y);
        this.counter = 0;
        this.cycleLength = cycleLength;
    }

    public void takeTurn () {
        counter++;
        counter = counter % cycleLength;
        if (counter == 0) {
            priority = (priority + 1) % 4;
        }
    }
}
