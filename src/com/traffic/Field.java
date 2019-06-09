package com.traffic;

import java.awt.*;

public interface Field extends Location {
    Location nextLocation();
    boolean isEmpty();
    void takeField();
    void freeField();
    void paintField(Graphics g);

    default boolean isIntersection() {
        return false;
    }
}