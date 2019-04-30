package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainPanel extends JPanel {

    private ArrayList<Intersection> intersections;
    private ArrayList<Street> streets;
    private ArrayList<Car> cars;

    public MainPanel() {
        intersections = new ArrayList<>();
        streets = new ArrayList<>();
        cars = new ArrayList<>();

    }

    public void update(ArrayList<Intersection> intersections, ArrayList<Street> streets, ArrayList<Car> cars) {
        this.intersections = intersections;
        this.streets = streets;
        this.cars = cars;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Street s : streets)
            s.paintStreet(g);
        for (Intersection i : intersections)
            i.paintIntersection(g);
        for (Car c : cars)
            c.paintCar(g);

    }
}
