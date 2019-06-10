package com.traffic;

import java.util.ArrayList;
import java.util.List;
import java.awt.*;

public class Line {
    public static final double WIDTH = 2.0;
    private List<Field> fields;
    private Intersection startInter;
    private Intersection finalInter;

    public Line(Intersection start, Intersection end) {
        this.startInter = start;
        this.finalInter = end;

        Point s = new Point(startInter.getCoordinates());
        Point t = new Point(finalInter.getCoordinates());
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

    private Polygon area() {
        Point start = new Point(startInter.getCoordinates());
        Point end = new Point(finalInter.getCoordinates());
        Point vec = start.substr(end).normalize();
        Point ort = vec.rotate90();
        Point trans = ort.scale(3);
        start = start.substr(trans);
        end = end.substr(trans);

        ort = ort.scale(WIDTH);

        ArrayList<Point> res = new ArrayList<>();
        res.add(start.add(ort));
        res.add(start.substr(ort));
        res.add(end.substr(ort));
        res.add(end.add(ort));

        Polygon result = new Polygon();
        for (Point p : res) result.addPoint((int) Math.round(p.x), (int) Math.round(p.y));
        return result;
    }

    public void paint(Graphics g) {
        g.setColor(Color.gray);

        g.fillPolygon(area());
    }
}
