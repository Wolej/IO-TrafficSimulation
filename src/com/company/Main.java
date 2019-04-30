package com.company;

import javax.swing.*;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) {

        MainPanel m = new MainPanel();

        Simulation simulation = new Simulation(m);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(m);
            }

        });

        simulation.play();
    }

    private static void createAndShowGUI(MainPanel m) {
        System.out.println("Created GUI on EDT? "+
                SwingUtilities.isEventDispatchThread());
        JFrame f = new JFrame("Main Window");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(m);
        f.setSize(350,350);
        f.setVisible(true);
    }
}
