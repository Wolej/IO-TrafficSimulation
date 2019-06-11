package com.traffic;

import java.awt.*;

public class FourIntersection extends Intersection {
    private int direction = 0;

    public FourIntersection(int x, int y) {
        super(x, y);
    }

    protected boolean canDrive(int from, int to) {
        if (from == to) return false;
        if (from == direction) {
            if (to == (direction + 2) % 4 || to == (direction + 1) % 4) {
                return true;
            }
            return inFields.get((from + 2) % 4).isEmpty();
        }
        else if (from == (direction + 2) % 4) {
            if (to == direction || to == (direction + 3) % 4) {
                return true;
            }
            return inFields.get((from + 2) % 4).isEmpty();
        }
        return false;
    }

    @Override
    public void paintLights(Graphics _g) {
        Graphics2D g = (Graphics2D) _g;
        for (int i = 0; i < lights.size(); ++i) {
            Polygon p = lights.get(i);
            Color col = new Color(1.0f, 0.0f, 0.0f, 0.0f);
            if (i % 2 == 0) col = new Color(0.0f, 1.0f, 0.0f, 1.0f);

            GradientPaint gradient = new GradientPaint(p.xpoints[0], p.ypoints[0], col, p.xpoints[3], p.ypoints[3], Color.WHITE);
            g.setPaint(gradient);
            g.fillPolygon(p);
        }
    }
}
