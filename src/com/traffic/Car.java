package com.traffic;

import java.awt.*;

public interface Car {
    void takeTurn();
    void paintCar(Graphics g);
    Field getField();
    Field getNextField();
}
