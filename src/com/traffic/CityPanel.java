package com.traffic;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CityPanel extends JPanel {
    private ArrayList<Car> cars;
    private ArrayList<Intersection> intersections;

    public CityPanel() {
        cars = new ArrayList<Car> ();
        intersections = new ArrayList<Intersection> ();

        Field f = new Field(100, 100);
        Driver d = new RandomDriver();
        cars.add(new SimpleDrivenCar(f, d));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //for (Intersection i : intersections)
          //  i.paintIntersection(g);
        for (Car c : cars)
            c.paintCar(g);
    }
}
