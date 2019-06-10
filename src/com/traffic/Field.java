package com.traffic;

import java.awt.*;

public class Field extends Location {
    private Location nextLoc;
    private boolean taken = false;

    public Field(int x, int y) {
        super(x, y);
    }

    public Location nextLocation() {
        return nextLoc;
    }
    public boolean isEmpty() {
        return !taken;
    }
    public void takeField() {
        taken = true;
    }
    public void freeField() {
        taken = false;
    }
    public void paintField(Graphics g) {

    }

    public void setNextLoc(Location loc) {
        this.nextLoc = loc;
    }

    public boolean isIntersection() {
        return false;
    }
}