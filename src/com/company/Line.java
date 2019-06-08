package com.company;

import java.awt.*;

public class Line {
    private int xCo, yCo;   //coordinates of line's beginning
    private int xECo, yECo;  //coordinates of line's ending
    private Field[] fields;
    private Intersection finalIntersection;     //intersection at the end of the line

    public Line(int xCo, int yCo, int xECo, int yECo, Intersection finalIntersection) {
        this.xCo = xCo;
        this.yCo = yCo;
        this.xECo = xECo;
        this.yECo = yECo;
        this.finalIntersection = finalIntersection;

        int length = 40;
        fields = new Field [length];

        for (int i = 0; i < length; i++) {
            fields[i] = new Field(xCo + ((xECo - xCo) / length) * i, yCo + ((yECo - yCo) / length) * i, this);
        }

        for (int i = 0; i < length - 1; i++) {
            fields[i].setNextField(fields[i + 1]);
        }

    }

    public Field getFirstField() {
        return fields[0];
    }

    public Intersection getFinalIntersection() {
        return finalIntersection;
    }

    public void drawLine(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawLine(xCo, yCo, xECo, yECo);
    }
}
