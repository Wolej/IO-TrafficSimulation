package com.traffic;

import java.util.List;

public class Street {
    private List<Intersection> intersections;   //List of intersections connected by the street (usually two)
    private List<Line> lines;   //List of traffic lines

    public int howManyWaiting(Intersection intersection) {
        int res = 0;
        for (Line l : lines) {
            res += l.howManyWaiting(intersection);
        }
        return res;
    }
}
