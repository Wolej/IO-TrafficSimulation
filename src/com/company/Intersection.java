package com.company;

import java.awt.*;

public class Intersection {
    private int priority;   // 0 - N, 1 - W, 2 - S, 3 - E
    private Street streets[];
    private int x, y;
    private int counter;


    public Intersection(int x, int y) {
        priority = 0;
        this.x = x;
        this.y = y;
        counter = 0;
    }

    public void takeTurn () {
        counter++;
        counter = counter % 10;
        if (true) {
            priority = (priority + 1) % 4;
        }
    }

    public boolean hasPriority (Street s) {
        return s == streets[priority];
    }

    public void paintIntersection(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x, y, 20, 20);
        g.setColor(Color.GREEN);
        g.fillArc(x, y, 20, 20, 45 + priority * 90, 90);
    }



}
