package com.traffic;

import javax.swing.*;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class Simulation {
    public CityPanel city;
    private ArrayList<Car> cars;
    private ArrayList<Intersection> intersections;
    private ArrayList<Street> streets;

    public Simulation() {
        cars = new ArrayList<Car>();
        intersections = new ArrayList<Intersection> ();
        streets = new ArrayList<Street>();

        Intersection a = new Intersection(200, 200);
        Intersection b = new Intersection(500, 500);
        Intersection c = new Intersection( 200, 500);
        Street s = new Street(a, b);
        streets.add(s);
        streets.add(new Street(a, c));

        intersections.add(a);
        intersections.add(b);
        intersections.add(c);

        Field f = new Field(100, 100);
        Driver d = new RandomDriver();
        cars.add(new SimpleDrivenCar(f, d));

        city = new CityPanel(streets);
    }

    void update() {
        for (Car c : cars) {
            c.takeTurn();
        }

        for (Intersection i : intersections) {
            i.takeTurn();
        }

        city.update(cars, intersections);
        city.repaint();
    }
}
