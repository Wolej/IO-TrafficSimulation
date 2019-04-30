package com.company;

public class Field {
    private int xCo, yCo;
    private Field nextField;
    private Car car;


    public Field(int xCo, int yCo) {
        this.xCo = xCo;
        this.yCo = yCo;
        nextField = null;
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

    public Intersection get
}
