package com.traffic;

import java.util.ArrayList;
import java.util.List;

public class DriverWithRoute extends DriverWithPersonality {
    private ArrayList<Field> route;
    private boolean alive = true;

    public DriverWithRoute(ArrayList<Field> route) {
        this.route = route;
    }

    public Field chooseField(List<Field> fields) {
        if (route.isEmpty()) {
            this.alive = false;
            return null;
        }
        return route.get(0);
    }

    @Override
    public void passedIntersection() {
        personality.passedIntersection();
        route.remove(0);
    }

    @Override
    public boolean isAlive() {
        return this.alive;
    }
}
