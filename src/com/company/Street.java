package com.company;

import java.awt.*;

import static java.awt.Color.BLACK;

public class Street {
    private int x, y;
    private int orientation;
    private Intersection lIntersection;
    private Intersection rIntersection;
    public Street(int x, int y, int orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public void paintStreet(Graphics g) {
        g.setColor(BLACK);

    }
}
