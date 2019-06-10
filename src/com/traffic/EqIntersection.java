package com.traffic;

public class EqIntersection extends Intersection {
    private int counter;
    private int cycleLength;
    private int priority;

    public EqIntersection(int x, int y, int cycleLength) {
        super(x, y);
        this.counter = 0;
        this.priority = 0;
        this.cycleLength = cycleLength;
    }

    @Override
    protected boolean canDrive(int from, int to) {
        return from == priority;
    }

    public void takeTurn () {
        counter++;
        counter = counter % cycleLength;
        if (counter == 0) {
            priority = (priority + 1) % inFields.size();
        }
    }
}
