package com.traffic;

import javax.imageio.*;
import javax.imageio.stream.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class MainWindow extends JFrame implements KeyListener, ActionListener {
    public static final int FRAME_LENGTH = 30;
    public static final double QUALITY = 1.0;
    private ArrayList<Simulation> simulations;
    private boolean recording = false;
    private GifSequenceWriter gif;

    private void makeScreenshot() {
        BufferedImage img = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
        this.paint(img.getGraphics());
        try {
            ImageIO.write(img, "png", new File("screen.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == ' ') {
            System.out.println("Pause");
        }
        else if (e.getKeyChar() == 's') {
            makeScreenshot();
        }
        else if (e.getKeyChar() == 'r') {
            recording = !recording;
            if (gif == null) {
                try {
                    ImageOutputStream output = new FileImageOutputStream(new File("video.gif"));
                    gif = new GifSequenceWriter(output, BufferedImage.TYPE_INT_RGB, FRAME_LENGTH, true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public void keyTyped(KeyEvent e) {}

    public void keyReleased(KeyEvent e) {}

    public void actionPerformed(ActionEvent ev) {
        for (Simulation s : simulations) {
            s.update();
        }

        if (recording) {
            BufferedImage img = new BufferedImage((int) Math.round(this.getWidth() * QUALITY), (int) Math.round(this.getHeight() * QUALITY), BufferedImage.TYPE_INT_RGB);
            Graphics2D g = (Graphics2D) img.getGraphics();
            AffineTransform at = new AffineTransform();
            at.scale(QUALITY, QUALITY);
            g.transform(at);
            this.paint(g);
            try {
                gif.writeToSequence(img);
            } catch (Exception e) {
                e.printStackTrace();
            }
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

        int maxWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int scale = Math.min(Configuration.SCALE, maxWidth / simulations.size());

        this.setSize(scale * simulations.size(),scale);
        this.setVisible(true);
        addKeyListener(this);

        Timer t = new Timer(FRAME_LENGTH, this);
        t.start();
    }
}
