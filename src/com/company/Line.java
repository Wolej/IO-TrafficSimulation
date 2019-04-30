package com.company;

import java.util.ArrayList;

public class Line {
    private int xCo, yCo;   //coordinates of line's beginning
    private int xECo, yECo  //coordinates of line's ending
    private Field[] fields;
    private Intersection finalIntersection;     //intersection at the end of the line

    public Line(int xCo, int yCo, int orientation, Intersection finalIntersection) {
        this.xCo = xCo;
        this.yCo = yCo;
        this.finalIntersection = finalIntersection;
        fields = new Field [20];

        for (int i = 0; i < 20; i++) {
            fields[i] = new Field(xCo + ((xECo - xCo) / 20) * i, yCo + ((yECo - yCo) / 20) * i);
        }

        for (int i = 0; i < 19; i++) {
            fields[i].setNextField(fields[i + 1]);
        }


    }

    public Intersection getFinalIntersection() {
        return finalIntersection;
    }
}
