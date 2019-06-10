package com.traffic;

import java.awt.*;

public class Field extends Location {
    private Location nextLoc;

    public Field(int x, int y) {
        super(x, y);
    }

    public Location nextLocation() {
        return nextLoc;
    }
    public boolean isEmpty() {
        return false;
    }
    public void takeField() {

    }
    public void freeField() {

    }
    public void paintField(Graphics g) {

    }

    public boolean isIntersection() {
        return false;
    }
}