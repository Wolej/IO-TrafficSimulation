package com.traffic;

import java.awt.*;
import java.util.List;

public interface Intersection extends Location {
    boolean hasPriority(Location location);
    void takeTurn();
    List<Field> getOutFields();
    void paintIntersection(Graphics g);

    default boolean isIntersection() {
        return true;
    }
}
