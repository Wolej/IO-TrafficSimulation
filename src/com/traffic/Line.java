package com.traffic;

import java.util.ArrayList;
import java.util.List;
import java.awt.*;

public class Line {
    public static final double WIDTH = 5.0;
    private List<Field> fields;
    private Intersection startInter;
    private Intersection finalInter;

    public Line(Intersection start, Intersection end) {
        this.startInter = start;
        this.finalInter = end;

        Point s = new Point(startInter.getCoordinates());
        Point t = new Point(finalInter.getCoordinates());
        Point vec = s.substr(t).normalize();
        s = s.substr(vec.scale(Configuration.RADIUS));
        t = t.add(vec.scale(Configuration.RADIUS));
        Point ort = vec.rotate90();
        ort = ort.scale(WIDTH);
        s = s.substr(ort);
        t = t.substr(ort);
        double dist = s.substr(t).norm();
        int fieldsN = 1 + (int) Math.floor(dist / 10);

        fields = new ArrayList<>();

        for (int i = 0; i < fieldsN; ++i) {
            double k = (double) i / (fieldsN - 1);
            Point f = t.scale(k).add(s.scale(1.0 - k));
            fields.add(new Field((int) Math.round(f.x), (int) Math.round(f.y)));
        }

        for (int i = 0; i + 1 < fieldsN; ++i) {
            fields.get(i).setNextLoc(fields.get(i + 1));
        }

        fields.get(fieldsN - 1).setNextLoc(end);
    }

    public Field getFirstField() {
        return fields.get(0);
    }

    public Field getLastField() {
        return fields.get(fields.size() - 1);
    }

    public int howManyWaiting(Intersection intersection) {
        if (intersection != finalInter) {
            return 0;
        } else {
            int res = 0;
            for (Field f : fields) {
                if (!f.isEmpty())
                    res++;
            }
            return res;
        }
    }

    private void drawLine(Graphics g, Point p, Point q) {
        g.drawLine((int) Math.round(p.x), (int) Math.round(p.y), (int) Math.round(q.x), (int) Math.round(q.y));
    }

    public void paint(Graphics g) {
        Point start = new Point(startInter.getCoordinates());
        Point end = new Point(finalInter.getCoordinates());
        Point vec = start.substr(end).normalize();
        start = start.substr(vec.scale(Configuration.RADIUS));
        end = end.add(vec.scale(Configuration.RADIUS));
        Point ort = vec.rotate90();
        ort = ort.scale(WIDTH);

        g.setColor(Color.gray);
        drawLine(g, start.substr(ort), end.substr(ort));
    }
}
