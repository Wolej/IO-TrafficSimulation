package com.traffic;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Intersection extends Location {
    protected List<Field> outFields;
    protected List<Field> inFields;
    protected List<Field> allFields;
    protected List<Polygon> lights;

    private class OrientedField implements Comparable<OrientedField> {
        private Field f;
        private Point direction;

        public OrientedField(Field f, Point dir) {
            this.f = f;
            this.direction = dir;
        }

        private int halfPlane() {
            if (direction.y > 0 || (direction.y == 0 && direction.x > 0)) {
                return 0;
            } else {
                return 1;
            }
        }

        public int compareTo(OrientedField of) {
            int h1 = this.halfPlane();
            int h2 = of.halfPlane();
            if (h1 == h2) {
                double cross = direction.times(of.direction);
                if (cross < 0) return 1;
                else return -1;
            }
            return h1 - h2;
        }
    }

    private List<OrientedField> outOFields;
    private List<OrientedField> inOFields;

    public Intersection(int x, int y) {
        super(x, y);
        outOFields = new ArrayList<>();
        inOFields = new ArrayList<>();
    }

    public void takeTurn() {
        /*
        jakasLista.clear();
        for (Car c : cars) {
            int idx1 = outFields.indexOf(c.getField());
            int idx2 = outFields.indexOf(c.getNextField());

            if (canDrive(idx1, idx2)) {
                jakasLista.put(idx1, idx2);
                cars.remove(c);
            }
        }*/
    }

    protected boolean canDrive(int from, int to) {
        return false;
    }

    public boolean canDrive(Field from, Field to) {
        return canDrive(inFields.indexOf(from), outFields.indexOf(to));
    }

    public void addInField(Field f, Point vec) {
        inOFields.add(new OrientedField(f, vec));
    }

    public void addOutField(Field f, Point vec) {
        outOFields.add(new OrientedField(f, vec));
    }

    public void sortFields() {
        Collections.sort(inOFields);
        Collections.sort(outOFields);

        inFields = new ArrayList<>();
        outFields = new ArrayList<>();
        allFields = new ArrayList<>();
        lights = new ArrayList<>();

        for (OrientedField of : inOFields) {
            inFields.add(of.f);
        }
        for (OrientedField of : outOFields) {
            outFields.add(of.f);
        }

        for (int i = 0; i < inOFields.size(); ++i) {
            allFields.add(inFields.get(i));
            allFields.add(outFields.get(i));
        }

        for (OrientedField of : inOFields) {
            lights.add(rectangle(new Point(of.f.getCoordinates()), of.direction));
        }
    }

    public List<Field> getOutFields() {
        return outFields;
    }

    public void paintIntersection(Graphics g) {
        g.setColor(Color.white);
        int r = Configuration.RADIUS;
        g.fillOval(this.getCoordinates().getX() - r, this.getCoordinates().getY() - r, 2 * r, 2 * r);
        g.setColor(Color.black);
        g.drawOval(this.getCoordinates().getX() - r, this.getCoordinates().getY() - r, 2 * r, 2 * r);
    }

    public void paintLights(Graphics g) {
    }

    public boolean isIntersection() {
        return true;
    }

    private Polygon rectangle(Point start, Point direction) {
        direction = direction.normalize().scale(Configuration.RADIUS * 1.5);
        Point end = start.add(direction);
        Point vec = start.substr(end).normalize();
        Point ort = vec.rotate90();
        Point trans = ort.scale(3);
        start = start.substr(trans);
        end = end.substr(trans);

        start = start.add(vec.scale(5));
        end = end.add(vec.scale(5));

        ort = ort.scale(10);

        ArrayList<Point> res = new ArrayList<>();
        res.add(start.add(ort));
        res.add(start.substr(ort));
        res.add(end.substr(ort));
        res.add(end.add(ort));

        Polygon result = new Polygon();
        for (Point p : res) result.addPoint((int) Math.round(p.x), (int) Math.round(p.y));
        return result;
    }
}
