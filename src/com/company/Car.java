package com.company;

import java.awt.*;

public class Car {
    private Field location;
    private int xCo, yCo;
    private Color color;
    private Driver driver;

    private void takeField(Field f) {
        f.beTaken(this);
    }

    public Car(int x, int y) {
        xCo = x;
        yCo = y;
        color = Color.BLUE;
        driver = new Driver();
    }


    public void paintCar(Graphics g) {
        g.setColor(color);
        g.fillOval(xCo - 1, yCo - 1, 4, 4);
    }

    public void takeTurn() {

    }
}
