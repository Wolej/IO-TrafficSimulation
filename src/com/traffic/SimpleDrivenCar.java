package com.traffic;

import java.awt.*;

public class SimpleDrivenCar implements Car {
    private Field field;
    private Driver driver;

    public SimpleDrivenCar(Field startingField, Driver driver) {
        field = startingField;
        this.driver = driver;
    }

    public void takeTurn() {
        Location nextLoc = field.nextLocation();
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
        }
    }

    public void paintCar(Graphics g) {
        Coordinates coordinates = field.getCoordinates();

        float angerLevel = driver.getAngerLevel();
        g.drawOval(coordinates.getX(), coordinates.getY(), 10, 10);
    }
}
