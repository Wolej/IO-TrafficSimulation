package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class MainPanel extends JPanel {
    private ArrayList<Intersection> intersections;
    public MainPanel() {

        intersections = new ArrayList<Intersection>();

        for (int i = 50; i < 3000; i = i + 100)
            for (int j = 50; j < 3000; j = j + 100)
                intersections.add(new Intersection(i, j));


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


            this.repaint();
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Intersection i : intersections)
            i.paintIntersection(g);

    }
}
