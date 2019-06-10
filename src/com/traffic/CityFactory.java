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

    public Simulation gridSimulation(int n, int m, int r) {
        int gridWidth = (m - 1) * r;
        int gridHeight = (n - 1) * r;

        int diffx = Configuration.SCALE - gridWidth;
        int diffy = Configuration.SCALE - gridHeight;

        if (diffx < 0 || diffy < 0) throw new IllegalArgumentException();
        diffx /= 2;
        diffy /= 2;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                intersections.add(new EqIntersection(diffx + r * j, diffy + r * i, 30));
            }
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j + 1 < m; ++j) {
                streets.add(new Street(intersections.get(m * i + j), intersections.get(m * i + j + 1)));
            }
        }

        for (int j = 0; j < m; ++j) {
            for (int i = 0; i + 1 < n; ++i) {
                streets.add(new Street(intersections.get(m * i + j), intersections.get(m * (i + 1) + j)));
            }
        }

        for (int i = 0; i + 1 < n; ++i) {
            for (int j = 0; j + 1 < m; ++j) {
                streets.add(new Street(intersections.get(m * i + j), intersections.get(m * (i + 1) + j + 1)));
            }
        }

        for (Intersection in : intersections) {
            in.sortFields();
        }

        for (Intersection in : intersections) {
            cars.add(new Car(in.getOutFields().get(0), new RandomDriver()));
            cars.add(new Car(in.getOutFields().get(1), new RandomDriver()));
        }
        return new Simulation(intersections, streets, cars);
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

        return new Simulation(intersections, streets);
    }
}
