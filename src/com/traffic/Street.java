package com.traffic;

import java.util.ArrayList;
import java.util.List;
import java.awt.*;

public class Street {
    private List<Intersection> intersections;   //List of intersections connected by the street (usually two)
    private List<Line> lines;   //List of traffic lines

    public Street(Intersection l1, Intersection l2) {
        intersections = new ArrayList<>();
        lines = new ArrayList<>();
        intersections.add(l1);
        intersections.add(l2);

        lines.add(new Line(l1, l2));
        lines.add(new Line(l2, l1));
    }

    public int howManyWaiting(Intersection intersection) {
        int res = 0;
        for (Line l : lines) {
            res += l.howManyWaiting(intersection);
        }
        return res;
    }

    public void paint(Graphics g) {
        for (Line l : lines) {
            l.paint(g);
        }
    }
}
