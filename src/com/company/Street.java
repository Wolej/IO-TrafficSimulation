package com.company;

import java.awt.*;

public class Street {
    private Intersection lIntersection;
    private Intersection rIntersection;

    private Line lLine, rLine;

    public Street(Intersection lIntersection, Intersection rIntersection) {
        int x = lIntersection.getxCo();
        int y = lIntersection.getyCo();
        this.lIntersection = lIntersection;
        this.rIntersection = rIntersection;

        double r = 2;

        double vx = rIntersection.getxCo() - lIntersection.getxCo();
        double vy = rIntersection.getyCo() - lIntersection.getyCo();
        double norm = Math.sqrt(vx * vx + vy * vy);
        vx *= r / norm;
        vy *= r / norm;

        int dx1 = (int) Math.round(-vy);
        int dy1 = (int) Math.round(vx);
        int dx2 = (int) Math.round(vx);
        int dy2 = (int) Math.round(vy);

        lLine = new Line(lIntersection.getxCo() + dx1 + dx2, lIntersection.getyCo() + dy1 + dy2,
                        rIntersection.getxCo() + dx1 - dx2, rIntersection.getyCo() + dy1 - dy2, rIntersection);
        rLine = new Line(rIntersection.getxCo() - dx1 - dx2, rIntersection.getyCo() - dy1 - dy2,
                    lIntersection.getxCo() - dx1 + dx2, lIntersection.getyCo() - dy1 + dy2, lIntersection);
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
