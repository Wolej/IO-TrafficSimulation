package com.traffic;

import java.awt.*;
import java.util.List;

public class Intersection extends Location {
    private static final int radius = 15;
    private List<Field> outFields;
    private List<Car> cars;
    protected int priority;

    public Intersection(int x, int y) {
        super(x, y);
    }

    public void takeTurn() {
        jakasLista.clear();
        for (Car c : cars) {
            int idx1 = outFields.indexOf(c.getField());
            int idx2 = outFields.indexOf(c.getNextField());

            if (canDrive(idx1, idx2)) {
                jakasLista.put(idx1, idx2);
                cars.remove(c);
            }
        }
    }

    public boolean canDrive(int from, int to) {
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
