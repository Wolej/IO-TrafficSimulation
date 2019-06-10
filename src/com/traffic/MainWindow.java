package com.traffic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class MainWindow extends JFrame implements KeyListener, ActionListener {
    public static final int FRAME_LENGTH = 30;
    private ArrayList<Simulation> simulations;

    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == ' ') {
            System.out.println("Pause");
        }
    }

    public void keyTyped(KeyEvent e) {}

    public void keyReleased(KeyEvent e) {}

    public void actionPerformed(ActionEvent e) {
        for (Simulation s : simulations) {
            s.update();
        }
    }

    public MainWindow(ArrayList<Simulation> simulations) {
        super("Traffic simulation");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(1, simulations.size()));
        this.simulations = simulations;

        for (Simulation s : simulations) {
            this.add(s.city);
        }

        this.setSize(1200,1200);
        this.setVisible(true);
        addKeyListener(this);

        Timer t = new Timer(FRAME_LENGTH, this);
        t.start();
    }
}
