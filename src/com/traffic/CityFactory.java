package com.traffic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CityFactory {
    private ArrayList<Car> cars;
    private ArrayList<Intersection> intersections;
    private ArrayList<Street> streets;
    private Random rng;

    public CityFactory() {
        cars = new ArrayList<Car>();
        intersections = new ArrayList<Intersection>();
        streets = new ArrayList<Street>();
        rng = new Random();
    }

    public Simulation gridSimulation(int n, int m, int r, int a, int b) {
        int gridWidth = (m - 1) * r;
        int gridHeight = (n - 1) * r;

        int diffx = Configuration.SCALE - gridWidth;
        int diffy = Configuration.SCALE - gridHeight;

        if (diffx < 0 || diffy < 0) throw new IllegalArgumentException();
        diffx /= 2;
        diffy /= 2;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                intersections.add(new CyclicIntersection(diffx + r * j, diffy + r * i, rng.nextInt(b - a + 1) + a, rng.nextInt(6)));
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
            cars.add(new Car(in.getOutFields().get(0), new RandomDriver()));
            cars.add(new Car(in.getOutFields().get(0), new RandomDriver()));
            cars.add(new Car(in.getOutFields().get(1), new RandomDriver()));
            cars.add(new Car(in.getOutFields().get(1), new RandomDriver()));
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

    public Simulation crossingA(int a, int b) {
        int size = Configuration.SCALE;
        int r = size;
        Intersection in = new FourIntersection(size / 2, size / 2);
        intersections.add(in);
        int x = r;
        int y = 0;

        for (int i = 0; i < 4; ++i) {
            Intersection ii = new Intersection(size / 2 + x, size / 2 + y);
            intersections.add(ii);
            streets.add(new Street(in, ii));

            int nx = -y;
            int ny = x;
            x = nx;
            y = ny;
        }

        for (Intersection i : intersections) {
            i.sortFields();
        }

        Intersection start = intersections.get(2);
        for (int i = 0; i < 40; ++i) {
            ArrayList<Field> route = new ArrayList<>();
            Line l = start.getOutLines().get(0);
            int na = a;
            if (na == 0) na = 1 + rng.nextInt(3);
            route.add(in.turn(l.getLastField(), na));

            Car c = new Car(l.getFirstField(), new DriverWithRoute(route));
            cars.add(c);
        }

        Intersection end = intersections.get(4);
        for (int i = 0; i < 20; ++i) {
            ArrayList<Field> route = new ArrayList<>();
            Line l = end.getOutLines().get(0);
            int nb = b;
            if (nb == 0) nb = 1 + rng.nextInt(3);
            route.add(in.turn(l.getLastField(), nb));

            Car c = new Car(l.getFirstField(), new DriverWithRoute(route));
            cars.add(c);
        }

        return new Simulation(intersections, streets, cars);
    }

    public Simulation crossingB(int a, int b, int cycle) {
        int size = Configuration.SCALE;
        int r = size;
        Intersection in = new CyclicIntersection(size / 2, size / 2, cycle, 0);
        intersections.add(in);
        int x = r;
        int y = 0;

        for (int i = 0; i < 4; ++i) {
            Intersection ii = new Intersection(size / 2 + x, size / 2 + y);
            intersections.add(ii);
            streets.add(new Street(in, ii));

            int nx = -y;
            int ny = x;
            x = nx;
            y = ny;
        }

        for (Intersection i : intersections) {
            i.sortFields();
        }

        Intersection start = intersections.get(2);
        for (int i = 0; i < 40; ++i) {
            ArrayList<Field> route = new ArrayList<>();
            Line l = start.getOutLines().get(0);
            int na = a;
            if (na == 0) na = 1 + rng.nextInt(3);
            route.add(in.turn(l.getLastField(), na));

            Car c = new Car(l.getFirstField(), new DriverWithRoute(route));
            cars.add(c);
        }

        Intersection end = intersections.get(4);
        for (int i = 0; i < 20; ++i) {
            ArrayList<Field> route = new ArrayList<>();
            Line l = end.getOutLines().get(0);
            int nb = b;
            if (nb == 0) nb = 1 + rng.nextInt(3);
            route.add(in.turn(l.getLastField(), nb));

            Car c = new Car(l.getFirstField(), new DriverWithRoute(route));
            cars.add(c);
        }

        return new Simulation(intersections, streets, cars);
    }

    public Simulation crossingX(boolean equal, boolean smart) {
        int size = Configuration.SCALE;
        int r = 2 * size;

        Intersection in;
        if (smart) {
            in = new EqIntersection(size / 2, size / 2);
        } else {
            in = new CyclicIntersection(size / 2, size / 2, 10, 0);
        }
        intersections.add(in);

        int n = 7;
        for (int i = 0; i < n; ++i) {
            double alph = 2. * Math.PI  * i / n;
            Intersection ii = new Intersection(size / 2 + (int) Math.round(Math.cos(alph) * r), size / 2 + (int) Math.round(Math.sin(alph) * r));
            intersections.add(ii);
            streets.add(new Street(in, ii));
        }

        for (Intersection i : intersections) {
            i.sortFields();
        }

        for (int i = 0; i < n; ++i) {
            int nr = 10;
            if (!equal) nr = 2 * (i + 1);
            for (int j = 0; j < nr; ++j) {
                int d = (1 + rng.nextInt(n - 1));
                Intersection start = intersections.get(i + 1);
                ArrayList<Field> route = new ArrayList<>();
                Line l = start.getOutLines().get(0);
                route.add(in.turn(l.getLastField(), d));

                Car c = new Car(l.getFirstField(), new DriverWithRoute(route));
                cars.add(c);
            }
        }

        return new Simulation(intersections, streets, cars);
    }

    public Simulation crossingX2(int n, int d) {
        int size = Configuration.SCALE;
        int r = 2 * size;

        Intersection in = new EqIntersection(size / 2, size / 2);
        intersections.add(in);

        for (int i = 0; i < n; ++i) {
            double alph = 2. * Math.PI  * i / n;
            Intersection ii = new Intersection(size / 2 + (int) Math.round(Math.cos(alph) * r), size / 2 + (int) Math.round(Math.sin(alph) * r));
            intersections.add(ii);
            streets.add(new Street(in, ii));
        }

        for (Intersection i : intersections) {
            i.sortFields();
        }

        for (int i = 0; i < n; ++i) {
            int nr = 20;
            for (int j = 0; j < nr; ++j) {
                Intersection start = intersections.get(i + 1);
                ArrayList<Field> route = new ArrayList<>();
                Line l = start.getOutLines().get(0);
                route.add(in.turn(l.getLastField(), d));

                Car c = new Car(l.getFirstField(), new DriverWithRoute(route));
                cars.add(c);
            }
        }

        return new Simulation(intersections, streets, cars);
    }
}
