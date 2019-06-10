package com.traffic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainWindow extends JFrame implements KeyListener {
    private CityPanel panel;

    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == ' ') {
            System.out.println("Pause");
        }
    }

    public void keyTyped(KeyEvent e) {}

    public void keyReleased(KeyEvent e) {}

    public MainWindow() {
        super("Main Window");
        panel = new CityPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(new GridLayout(1, 1));
        this.add(panel, BorderLayout.CENTER);
        this.setSize(1200,1200);
        this.setVisible(true);
        addKeyListener(this);
    }
}
