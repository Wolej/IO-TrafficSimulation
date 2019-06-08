package com.company;

import java.awt.*;

public class Street {
    private int orientation;        //0 - horizontal, 1 - vertical
    private Intersection lIntersection;
    private Intersection rIntersection;

    private Line lLine, rLine;

    public Street(int orientation, Intersection lIntersection, Intersection rIntersection) {
        int x = lIntersection.getxCo();
        int y = lIntersection.getyCo();
        this.lIntersection = lIntersection;
        this.rIntersection = rIntersection;

        this.orientation = orientation;

        int dx = -2 * orientation;
        int dy = 2 - 2 * orientation;
        lLine = new Line(lIntersection.getxCo() + dx, lIntersection.getyCo() + dy,
                        rIntersection.getxCo() + dx, rIntersection.getyCo() + dy, rIntersection);
        rLine = new Line(rIntersection.getxCo() - dx, rIntersection.getyCo() - dy,
                    lIntersection.getxCo() - dx, lIntersection.getyCo() - dy, rIntersection);
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
