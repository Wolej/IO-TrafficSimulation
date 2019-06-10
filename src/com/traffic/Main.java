package com.traffic;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Simulation> sims = new ArrayList<> ();
        sims.add(new CityFactory().sampleSimulation());
        sims.add(new CityFactory().gridSimulation(10, 10, 100));

        sims.add(new CityFactory().gridSimulation(5, 4, 200));
        MainWindow mainWindow = new MainWindow(sims);
    }
}
