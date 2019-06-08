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
    private boolean paused;

    private static final int TURN_TIME = 30;

    public Simulation(MainPanel panel) {
        intersectionsTable = new Intersection[10][10];
        intersections = new ArrayList<>();
        streets = new ArrayList<>();
        cars = new ArrayList<>();

        Random random = new Random();

        mainPanel = panel;

        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 10; j++) {
                intersectionsTable[i][j] = new Intersection(50 + 200 * i, 50 + 200 * j, 25 + (random.nextInt() % 5));
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
                for (int j = 0; j < 15; j++)
                    cars.add(new Car(it, i));
        }
    }

    public boolean pause() {
        paused = !paused;
        return paused;
    }

    public void unpause() {
        paused = true;
    }

    public void play() {
        int j = 0;

        mainPanel.update(intersections, streets, cars);
        mainPanel.repaint();

        long frameTime = System.currentTimeMillis();

        while (true) {
            long curTime = System.currentTimeMillis();
            if (frameTime + TURN_TIME < curTime) {
                System.err.println("FPS dropped");
            } else {
                try {
                    sleep(frameTime + TURN_TIME - curTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            frameTime = curTime;

            if (paused) {
                continue;
            } else {
                j++;
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
