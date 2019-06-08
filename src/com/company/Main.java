package com.company;

import javax.swing.*;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) {

        MainPanel m = new MainPanel();

        Simulation simulation = new Simulation(m);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(m, simulation);
            }

        });

        simulation.play();
    }

    private static void createAndShowGUI(MainPanel m, Simulation s) {
        System.out.println("Created GUI on EDT? "+
                SwingUtilities.isEventDispatchThread());
        JFrame f = new JFrame("Main Window");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MainWindow mainWindow = new MainWindow(s, m);


        f.add(mainWindow.$$$getRootComponent$$$());
        f.setSize(1400,1400);
        f.setVisible(true);
    }
}
