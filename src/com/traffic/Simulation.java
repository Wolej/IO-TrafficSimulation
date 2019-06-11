package com.traffic;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class Simulation {
    public CityPanel city;
    private ArrayList<Car> cars;
    private ArrayList<Intersection> intersections;
    private ArrayList<Street> streets;

    public Simulation(ArrayList<Intersection> intersections, ArrayList<Street> streets) {
        cars = new ArrayList<Car>();
        this.intersections = intersections;
        this.streets = streets;
        city = new CityPanel(streets);
    }

    public void addCar(Car c) {
        cars.add(c);
    }

    public void addCars(ArrayList<Car> cars) {
        for (Car c : cars) {
            addCar(c);
        }
    }

    public Simulation(ArrayList<Intersection> intersections, ArrayList<Street> streets, ArrayList<Car> cars) {
        this(intersections, streets);
        this.cars = cars;
    }

    void update() {
        for (Intersection i : intersections) {
            i.takeTurn();
        }

        for (int i = 0; i < cars.size(); ++i) {
            Car c = cars.get(i);
            if (c.isAlive()) {
                c.takeTurn();
            } else {
                cars.remove(i);
                i--;
            }
        }

        city.update(cars, intersections);
        city.repaint();
    }
}
