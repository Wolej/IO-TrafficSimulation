package com.traffic;

import java.util.ArrayList;
import java.util.List;

public class Street {
    private List<Intersection> intersections;   //List of intersections connected by the street (usually two)
    private List<Line> lines;   //List of traffic lines

    public Street(Intersection l1, Intersection l2) {
        intersections = new ArrayList<>();
        intersections.add(l1);
        intersections.add(l2);
    }

    public int howManyWaiting(Intersection intersection) {
        int res = 0;
        for (Line l : lines) {
            res += l.howManyWaiting(intersection);
        }
        return res;
    }
}
