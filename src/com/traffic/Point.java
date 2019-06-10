package com.traffic;

public class Point {
    public double x, y;

    public Point(Coordinates coord) {
        this.x = (double) coord.getX();
        this.y = (double) coord.getY();
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public Point() {
        this.x = 0.0;
        this.y = 0.0;
    }

    public Point add(Point p) {
        return new Point(x + p.x, y + p.y);
    }

    public Point substr(Point p) {
        return new Point(x - p.x, y - p.y);
    }

    public Point rotate90() {
        return new Point(-y, x);
    }

    public double norm() {
        return Math.sqrt(x * x + y * y);
    }

    public Point normalize() {
        double norm = this.norm();
        return new Point(x / norm, y / norm);
    }

    public Point scale(double k) {
        return new Point(x * k, y * k);
    }
}
