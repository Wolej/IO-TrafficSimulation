package com.traffic;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CityPanel extends JPanel {
    private ArrayList<Car> cars;
    private ArrayList<Intersection> intersections;
    private ArrayList<Street> streets;

    public CityPanel(ArrayList<Street> streets) {
        cars = new ArrayList<>();
        intersections = new ArrayList<>();
        this.streets = streets;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Street s : streets) {
            s.paint(g);
        }
        for (Intersection i : intersections) {
            i.paintIntersection(g);
        }
        for (Car c : cars) {
            c.paintCar(g);
        }

        g.setColor(Color.black);
        g.drawLine(10, 10, 590, 10);
        g.drawLine(10, 10, 10, 590);
    }

    public void update(ArrayList<Car> cars, ArrayList<Intersection> intersections) {
        this.cars = cars;
        this.intersections = intersections;
    }
}
