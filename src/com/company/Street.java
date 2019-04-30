package com.company;

import java.awt.*;

import static java.awt.Color.BLACK;

public class Street {
    private int x, y;
    private int orientation;        //0 - horizontal, 1 - vertical
    private Intersection lIntersection;
    private Intersection rIntersection;
    public Street(int x, int y, int orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public void paintStreet(Graphics g) {
        g.setColor(BLACK);

        int x1, x2, y1, y2;
        x1 = x - 2 * orientation;
        x2 = x + 2 * orientation;
        y1 = y + 2 - 2 * orientation;
        y2 = y - 2 + 2 * orientation;
        g.drawLine(x1, y1, x1 + 100 - 100 * orientation, y1 + 100 * orientation);
        g.drawLine(x2, y2, x2 + 100 - 100 * orientation, y2 + 100 * orientation);
    }

    public void takeTurn() {

    }
}
