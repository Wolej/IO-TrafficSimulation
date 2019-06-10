package com.traffic;

import java.awt.*;

public class SimpleDrivenCar implements Car {
    private Field field;
    private Driver driver;

    private static final int radius = 4;

    private double myAnger = 0.0;

    public SimpleDrivenCar(Field startingField, Driver driver) {
        field = startingField;
        this.driver = driver;
    }

    public void takeTurn() {
        myAnger += 0.01;
        if (myAnger > 1) myAnger -= 1;
        /*Location nextLoc = field.nextLocation();
        Field nextField;

        boolean atIntersection = nextLoc.isIntersection();

        if (atIntersection) {
            Intersection upcomingIntersection = (Intersection) nextLoc;

            if (!upcomingIntersection.hasPriority(field)){
                driver.trafficJammed();
                return;
            }

            nextField = driver.chooseField(upcomingIntersection.getOutFields());
        } else {
            nextField = (Field) nextLoc;
        }

        if (nextField.isEmpty()) {
            if (atIntersection)
                driver.passedIntersection();
            else
                driver.passedField();

            field.freeField();
            field = nextField;
            field.takeField();
        } else {
            driver.trafficJammed();
        }*/
    }

    public void paintCar(Graphics g) {
        Coordinates coordinates = field.getCoordinates();

        float angerLevel = (float) myAnger; //driver.getAngerLevel();
        g.setColor(new Color(angerLevel, 1.0f - angerLevel, 0));
        g.fillRect(coordinates.getX() - radius, coordinates.getY() - radius, 2 * radius, 2 * radius);
    }
}
