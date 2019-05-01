package com.company;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.Thread.sleep;

public class Simulation {
    private Intersection[][] intersectionsTable;
    private ArrayList<Intersection> intersections;
    private ArrayList<Street> streets;
    private ArrayList<Car> cars;
    private MainPanel mainPanel;

    public Simulation(MainPanel panel) {
        intersectionsTable = new Intersection[10][10];
        intersections = new ArrayList<>();
        streets = new ArrayList<>();
        cars = new ArrayList<>();

        Random random = new Random();

        mainPanel = panel;

        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 10; j++) {
                intersectionsTable[i][j] = new Intersection(50 + 100 * i, 50 + 100 * j, 20 + (random.nextInt() % 8));
                intersections.add(intersectionsTable[i][j]);
                }

        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 10; j++) {
                Intersection it = intersectionsTable[i][j];
                Intersection rIt = intersectionsTable[(i + 1) % 10][j];
                Intersection dIt = intersectionsTable[i][(j + 1) % 10];
                Street s = new Street(0, it, rIt);
                it.setOutField(s.getLeftFirstField(), 3);
                rIt.setOutField(s.getRightFirstField(), 1);
                streets.add(s);
                s = new Street(1, it, dIt);
                it.setOutField(s.getLeftFirstField(), 2);
                dIt.setOutField(s.getRightFirstField(), 0);
                streets.add(s);
            }




        for (Intersection it : intersections) {
            for (int i = 0; i < 4; i++)
                for (int j = 0; j < 3; j++)
                    cars.add(new Car(it, i));
        }
    }

    public void play() {
        int j = 0;
        Car car = (new Car(intersectionsTable[2][2], 3));
        cars.add(car);
        mainPanel.update(intersections, streets, cars);
        mainPanel.repaint();
        while (true) {
            j++;
            try {
                sleep(33);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Take a turn: " + j);

            for (Car c : cars)
                c.takeTurn();

            for (Intersection i : intersections)
                i.takeTurn();

            mainPanel.update(intersections, streets, cars);
            mainPanel.repaint();
        }
    }
}
