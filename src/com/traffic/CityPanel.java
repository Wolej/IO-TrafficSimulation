package com.traffic;

import javafx.scene.transform.Affine;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

public class CityPanel extends JPanel {
    private ArrayList<Car> cars;
    private ArrayList<Intersection> intersections;
    private ArrayList<Street> streets;

    public CityPanel(ArrayList<Street> streets) {
        cars = new ArrayList<>();
        intersections = new ArrayList<>();
        this.streets = streets;
        this.setBackground(Color.white);
    }

    public void paintComponent(Graphics _g) {
        super.paintComponent(_g);
        Graphics2D g = (Graphics2D) _g;

        AffineTransform at = new AffineTransform();
        double sc = (double) this.getWidth() / (double) Configuration.SCALE;
        at.scale(sc, sc);
        g.transform(at);

        for (Intersection i : intersections) {
            i.paintLights(g);
        }
        for (Street s : streets) {
            s.paint(g);
        }
        for (Intersection i : intersections) {
            i.paintIntersection(g);
        }
        for (Car c : cars) {
            c.paintCar(g);
        }

        int scale = Configuration.SCALE;
        int rr = 40;
        g.setColor(Color.white);
        g.fillRect(0, 0, scale, rr);
        g.fillRect(0, scale - rr, scale, rr);
        g.fillRect(0, 0, rr, scale);
        g.fillRect(scale - rr, 0, rr, scale);
    }

    public void update(ArrayList<Car> cars, ArrayList<Intersection> intersections) {
        this.cars = cars;
        this.intersections = intersections;
    }
}
