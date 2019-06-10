package com.traffic;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Simulation> sims = new ArrayList<> ();
        sims.add(new Simulation());
        sims.add(new Simulation());
        MainWindow mainWindow = new MainWindow(sims);
    }
}
