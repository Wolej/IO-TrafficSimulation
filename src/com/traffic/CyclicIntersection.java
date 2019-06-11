package com.traffic;

import java.awt.*;

public class CyclicIntersection extends Intersection {
    private int counter;
    private int cycleLength;
    private int priority;

    public CyclicIntersection(int x, int y, int cycleLength, int priority) {
        super(x, y);
        this.counter = 0;
        this.priority = priority;
        this.cycleLength = cycleLength;
    }

    @Override
    protected boolean canDrive(int from, int to) {
        return from == priority && from != to;
    }

    public void takeTurn () {
        counter++;
        counter = counter % cycleLength;
        if (counter == 0) {
            priority = (priority + 1) % inFields.size();
        }
    }

    @Override
    public void paintLights(Graphics _g) {
        Graphics2D g = (Graphics2D) _g;
        for (int i = 0; i < lights.size(); ++i) {
            Polygon p = lights.get(i);
            Color col = new Color(1.0f, 0.0f, 0.0f, 0.0f);
            if (i == priority) col = new Color(0.0f, 1.0f, 0.0f, 1.0f);

            GradientPaint gradient = new GradientPaint(p.xpoints[0], p.ypoints[0], col, p.xpoints[3], p.ypoints[3], Color.WHITE);
            g.setPaint(gradient);
            g.fillPolygon(p);
        }
    }
}
