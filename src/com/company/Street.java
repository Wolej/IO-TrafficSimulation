package com.company;

import java.awt.*;

public class Street {
    private int orientation;        //0 - horizontal, 1 - vertical
    private Intersection lIntersection;
    private Intersection rIntersection;
    private static final int LINE_LENGTH = 100;

    private Line lLine, rLine;

    public Street(int orientation, Intersection lIntersection, Intersection rIntersection) {
        int x = lIntersection.getxCo();
        int y = lIntersection.getyCo();
        this.lIntersection = lIntersection;
        this.rIntersection = rIntersection;

        int x1, x2, y1, y2;
        x1 = x - 2 * orientation;
        x2 = x + 2 * orientation;
        y1 = y + 2 - 2 * orientation;
        y2 = y - 2 + 2 * orientation;

        this.orientation = orientation;
        lLine = new Line(x1, y1, x1 + LINE_LENGTH - LINE_LENGTH * orientation, y1 + LINE_LENGTH * orientation, rIntersection);
        rLine = new Line(x2 + LINE_LENGTH - LINE_LENGTH * orientation, y2 + LINE_LENGTH * orientation, x2, y2, lIntersection);
    }

    public void paintStreet(Graphics g) {
        lLine.drawLine(g);
        rLine.drawLine(g);
    }

    public Field getLeftFirstField() {
        return lLine.getFirstField();
    }

    public Field getRightFirstField() {
        return rLine.getFirstField();
    }

    public void takeTurn() {

    }
}
