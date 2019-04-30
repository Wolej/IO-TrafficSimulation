package com.company;

import java.awt.*;

public class Car {
    private Field location;
    private int xCo, yCo;
    private Color color;

    public Car(int x, int y) {
        xCo = x;
        yCo = y;
        color = Color.BLUE;
    }


    public void paintCar(Graphics g) {
        g.setColor(color);
        g.fillOval(xCo - 1, yCo - 1, 4, 4);
    }

    public void takeTurn() {

    }
}
