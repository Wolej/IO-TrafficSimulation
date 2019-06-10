package com.traffic;

import java.awt.*;
import java.util.List;

public class Intersection extends Location {
    private static final int radius = 15;
    private List<Field> outFields;
    protected int priority;

    public Intersection(int x, int y) {
        super(x, y);
    }

    public void takeTurn() {

    }

    public boolean hasPriority(Field f) {
        return outFields.indexOf(f) == priority;
    }

    public List<Field> getOutFields() {
        return outFields;
    }

    public void paintIntersection(Graphics g) {
        g.setColor(Color.gray);
        g.fillOval(this.getCoordinates().getX() - radius, this.getCoordinates().getY() - radius, 2 * radius, 2 * radius);
    }

    public boolean isIntersection() {
        return true;
    }
}
