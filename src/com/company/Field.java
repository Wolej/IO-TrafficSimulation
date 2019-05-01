package com.company;

public class Field {
    private int xCo, yCo;
    private Field nextField;
    private Car car;
    private Line line;


    public Field(int xCo, int yCo, Line line) {
        this.xCo = xCo;
        this.yCo = yCo;
        nextField = null;
        this.line = line;
    }

    public void setNextField(Field nextField) {
        this.nextField = nextField;
    }

    public Field next() {
        return nextField;
    }

    public boolean isLastInLine () {
        return nextField == null;
    }

    public boolean isEmpty() {
        return car == null;
    }

    public void empty() {
        car = null;
    }

    public void beTaken(Car c) {
        car = c;
    }

    public int getxCo() {
        return xCo;
    }

    public int getyCo() {
        return yCo;
    }

    public Intersection getUpcomingIntersection() { return line.getFinalIntersection(); }
}
