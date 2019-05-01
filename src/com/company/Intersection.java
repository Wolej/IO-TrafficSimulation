package com.company;

import java.awt.*;

public class Intersection {
    private int priority;   // 0 - N, 1 - W, 2 - S, 3 - E
    private Field outFields[];
    private int xCo, yCo;
    private int counter;


    public Intersection(int x, int y) {
        priority = 0;
        this.xCo = x;
        this.yCo = y;
        counter = 0;

        outFields = new Field [4];
    }

    public void takeTurn () {
        counter++;
        counter = counter % 20;
        if (counter == 0) {
            priority = (priority + 1) % 4;
        }
    }

    public int getxCo() {
        return xCo;
    }

    public int getyCo() {
        return yCo;
    }

    public boolean hasPriority (int direction) {
        return direction == priority;
    }

    public void setOutField(Field outField, int direction) {
        outFields[direction] = outField;
    }

    public Field getOutField(int direction) {
        if (direction < 0)
            direction += 4;
        return outFields[direction];
    }

    public void paintIntersection(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(xCo - 10, yCo - 10, 20, 20);
        g.setColor(Color.GREEN);
        g.fillArc(xCo - 10, yCo - 10, 20, 20, 45 + priority * 90, 90);
    }
}
