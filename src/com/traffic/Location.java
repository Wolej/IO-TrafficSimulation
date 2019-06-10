package com.traffic;

public abstract class Location {
    private Coordinates coord;

    public Location(int x, int y) {
        coord = new Coordinates(x, y);
    }

    Coordinates getCoordinates() {
        return coord;
    }
    public abstract boolean isIntersection();
}
