package com.company;

import java.awt.*;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class Simulation {
    private ArrayList<Intersection> intersections;
    private ArrayList<Street> streets;
    private ArrayList<Car> cars;
    private MainPanel mainPanel;

    public Simulation(MainPanel panel) {
        intersections = new ArrayList<>();
        streets = new ArrayList<>();
        cars = new ArrayList<>();

        mainPanel = panel;

        for (int i = 50; i < 600; i = i + 100)
            for (int j = 50; j < 600; j = j + 100) {
                intersections.add(new Intersection(i, j));
                streets.add(new Street(i + 10, j + 10, 0));
                streets.add(new Street(i + 10, j + 10, 1));
                cars.add(new Car(i + 50, j + 11));
                cars.add(new Car(i + 11, j + 50));
            }


    }

    public void play() {
        int j = 0;
        while (true) {
            j++;
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Take a turn: " + j);

            for (Intersection i : intersections)
                i.takeTurn();

            mainPanel.update(intersections, streets, cars);
            mainPanel.repaint();
        }
    }
}
