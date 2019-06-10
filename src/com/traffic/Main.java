package com.traffic;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Simulation> sims = new ArrayList<> ();
        sims.add(new CityFactory().gridSimulation(6, 6, 150, 50, 80));
        sims.add(new CityFactory().gridSimulation(6, 6, 150, 4, 8));
        //sims.add(new CityFactory().gridSimulation(10, 10, 100, 50, 100));
        MainWindow mainWindow = new MainWindow(sims);
    }
}
