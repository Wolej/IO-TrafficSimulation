package com.company;

import java.util.Random;

public class Driver {
    public int resolveIntersection(Intersection intersection, int direction) {
        Random random = new Random();
        while (true) {
            direction = (direction + 1) % 4;
            if (intersection.getOutField(direction) != null) {
                return direction;
            }
        }
    }
}
