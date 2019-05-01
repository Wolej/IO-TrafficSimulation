package com.company;

import java.awt.*;

public class Car {
    private Field location;
    private int xCo, yCo;
    private Color color;
    private Driver driver;
    private int direction;

    private void takeField(Field f) {
        f.beTaken(this);
        location = f;
    }

    public Car(Field startLoc) {
        location = startLoc;
        color = Color.BLUE;
        driver = new Driver();

        if (location.isLastInLine()) {
            direction = 0;
        }
        else {
            Field nl = location.next();
            int x1 = location.getxCo();
            int x2 = nl.getxCo();
            int y1 = location.getyCo();
            int y2 = nl.getyCo();

            if(x1 != x2) {
                if (x1 > x2)
                    direction = 1;
                else
                    direction = 3;
            } else {
                if (y1 > y2)
                    direction = 0;
                else
                    direction = 2;
            }
        }
    }

    public Car(Intersection startingIntersection, int direction) {
        location = startingIntersection.getOutField(direction);
        color = Color.BLUE;
        driver = new Driver();
        this.direction = direction;
    }

    public void paintCar(Graphics g) {
        g.setColor(color);

        int x = location.getxCo();
        int y = location.getyCo();

        g.fillOval(x - 1, y - 1, 4, 4);
    }

    public void takeTurn() {
        Field nextField = location.next();
        int newDir = direction;
        if (location.isLastInLine()) {
            Intersection upcInt = location.getUpcomingIntersection();

            if (!upcInt.hasPriority((direction+2) % 4))
                return;

            newDir = driver.resolveIntersection(upcInt, direction);

            nextField = upcInt.getOutField(newDir);
        }

        if (nextField.isEmpty()) {
            location.empty();
            this.takeField(nextField);
            direction = newDir;
        }
    }
}
