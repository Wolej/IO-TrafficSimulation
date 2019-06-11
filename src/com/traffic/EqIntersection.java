package com.traffic;

import java.util.ArrayList;

public class EqIntersection extends Intersection {
    private ArrayList<Integer> starts;
    private ArrayList<Integer> ends;

    public EqIntersection(int x, int y) {
        super(x, y);
        starts = new ArrayList<>();
        ends = new ArrayList<>();
    }

    private boolean intersect(int a, int b, int x) {
        if (a < b) {
            return a < x && x < b;
        }
        else {
            return x < b || x > a;
        }
    }

    private boolean intersect(int a, int b, int c, int d) {
        return intersect(a, b, c) || intersect(a, b, d) || intersect(c, d, a) || intersect(c, d, b);
    }

    @Override
    protected boolean canDrive(int from, int to) {
        for (int i = 0; i < starts.size(); ++i) {
            if (intersect(starts.get(i), ends.get(i), from, to)) return false;
        }

        starts.add(from);
        ends.add(to);
        return true;
    }

    @Override
    public void takeTurn() {
        starts.clear();
        ends.clear();
    }
}
