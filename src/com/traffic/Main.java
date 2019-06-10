package com.traffic;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        CityPanel p = new CityPanel();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(p);
            }
        });
    }

    private static void createAndShowGUI(CityPanel p) {
        System.out.println("Created GUI on EDT? "+
                SwingUtilities.isEventDispatchThread());
        MainWindow mainWindow = new MainWindow();
    }
}
