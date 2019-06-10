package com.traffic;

import java.util.ArrayList;

public class CityFactory {
    private ArrayList<Car> cars;
    private ArrayList<Intersection> intersections;
    private ArrayList<Street> streets;

    public CityFactory() {
        cars = new ArrayList<Car>();
        intersections = new ArrayList<Intersection>();
        streets = new ArrayList<Street>();
    }

    public Simulation gridSimulation(int n, int m) {
        
        return new Simulation(intersections, streets);
    }

    public Simulation sampleSimulation() {
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

        return new Simulation(intersections, streets);
    }
}
