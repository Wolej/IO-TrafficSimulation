package com.company;

import java.util.Random;

public class Driver {
    public int resolveIntersection(Intersection intersection, int direction) {
        Random random = new Random();
        int r = random.nextInt() % 3;
        int res = (direction + r) % 4;
        if (res < 0)
            res += 4;
        return res;
    }
}
