package com.traffic;

import java.awt.*;
import java.util.List;

public class Intersection extends Location {
    private List<Field> outFields;

    public Intersection(int x, int y) {
        super(x, y);
    }

    public boolean hasPriority(Location location) {
        return false;
    }
    public void takeTurn() {

    }
    public List<Field> getOutFields() {
        return outFields;
    }
    public void paintIntersection(Graphics g) {

    }

    public boolean isIntersection() {
        return true;
    }
}
