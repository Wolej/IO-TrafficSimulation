package com.traffic;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Simulation> sims = new ArrayList<> ();
        //sims.add(new CityFactory().gridSimulation(6, 6, 150, 50, 80));
        //sims.add(new CityFactory().gridSimulation(2, 2, 400, 30, 50));
        //sims.add(new CityFactory().gridSimulation(10, 10, 100, 50, 100));

        //sims.add(new CityFactory().crossingA(2, 2));
        //sims.add(new CityFactory().crossingA(1, 1));
        //sims.add(new CityFactory().crossingA(2, 3));
        //sims.add(new CityFactory().crossingA(0, 1));

        /*
        sims.add(new CityFactory().crossingB(2, 2, 5));
        sims.add(new CityFactory().crossingB(0, 2, 5));

        sims.add(new CityFactory().crossingB(2, 2, 40));
        sims.add(new CityFactory().crossingB(0, 2, 40));
        */

        /*
        sims.add(new CityFactory().crossingX(false, false));
        sims.add(new CityFactory().crossingX(true, false));

        sims.add(new CityFactory().crossingX(false, true));
        sims.add(new CityFactory().crossingX(true, true));
        */

        sims.add(new CityFactory().crossingX2(6, 1));
        sims.add(new CityFactory().crossingX2(6, 5));
        sims.add(new CityFactory().crossingX2(6, 3));
        sims.add(new CityFactory().crossingX2(6, 2));
        MainWindow mainWindow = new MainWindow(sims);
    }
}
