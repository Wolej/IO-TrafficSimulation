package com.traffic;

import java.awt.*;

public class Car {
    private Field field;
    private Driver driver;
    boolean onIntersection = false;
    private Coordinates whereOnIntersection;

    public Car(Field startingField, Driver driver) {
        field = startingField;
        this.driver = driver;
    }

    public boolean isAlive() {
        return driver.isAlive();
    }

    public void takeTurn() {
        if (!driver.drive()) {
            return;
        }
        if (onIntersection) {
            driver.passedIntersection();
            onIntersection = false;
            return;
        }

        Location nextLoc = field.nextLocation();
        Field nextField = null;

        boolean atIntersection = nextLoc.isIntersection();

        if (atIntersection) {
            Intersection upcomingIntersection = (Intersection) nextLoc;

            nextField = driver.chooseField(upcomingIntersection.getOutFields());
            if (nextField == null) {
                field.freeField();
                return;
            }
            if (!upcomingIntersection.canDrive(field, nextField) || !nextField.isEmpty()) {
                driver.trafficJammed();
                return;
            }

            onIntersection = true;
            whereOnIntersection = middlePoint(field.getCoordinates(), nextField.getCoordinates());
            field.freeField();
            field = nextField;
            field.takeField();
        } else {
            nextField = (Field) nextLoc;
            if (nextField.isEmpty()) {
                nextField = (Field) nextLoc;
                driver.passedField();
                field.freeField();
                field = nextField;
                field.takeField();
            }
            else {
                driver.trafficJammed();
            }
        }
    }

    public void paintCar(Graphics g) {
        Coordinates coordinates = field.getCoordinates();
        if (onIntersection) coordinates = whereOnIntersection;

        float anger = driver.getAngerLevel();
        g.setColor(new Color(anger, 1.0f - anger, 0));
        int radius = Configuration.CAR_RADIUS;
        g.fillRect(coordinates.getX() - radius, coordinates.getY() - radius, 2 * radius, 2 * radius);
        g.setColor(Color.black);
        g.drawRect(coordinates.getX() - radius, coordinates.getY() - radius, 2 * radius, 2 * radius);
    }

    private Coordinates middlePoint(Coordinates a, Coordinates b) {
        return new Coordinates((a.getX() + b.getX()) / 2, (a.getY() + b.getY()) / 2);
    }
}
