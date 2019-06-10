package com.traffic;

import java.awt.*;

public class Car {
    private Field field;
    private Driver driver;

    private static final int radius = 4;

    public Car(Field startingField, Driver driver) {
        field = startingField;
        this.driver = driver;
    }

    public void takeTurn() {
        Location nextLoc = field.nextLocation();
        Field nextField = null;

        boolean atIntersection = nextLoc.isIntersection();

        if (atIntersection) {
            Intersection upcomingIntersection = (Intersection) nextLoc;

            nextField = driver.chooseField(upcomingIntersection.getOutFields());
            if (!upcomingIntersection.canDrive(field, nextField)) {
                driver.trafficJammed();
                return;
            }
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
        }
    }

    public void paintCar(Graphics g) {
        Coordinates coordinates = field.getCoordinates();

        float anger = driver.getAngerLevel();
        g.setColor(new Color(anger, 1.0f - anger, 0));
        g.fillRect(coordinates.getX() - radius, coordinates.getY() - radius, 2 * radius, 2 * radius);
    }
}
