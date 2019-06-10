package com.traffic;

import java.util.Timer;
import java.util.TimerTask;

public class TimeIntersection extends Intersection {
    private int priority;

    public TimeIntersection(int x, int y, int[] secs) {
        super(x,y);
        priority = 0;
        Timer t = new Timer();

        t.scheduleAtFixedRate(
                new TimerTask() {
                    public void run() {
                        try {
                            Thread.sleep(1000*secs[priority]);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        priority = (priority + 1) % 4;
                    }
                },
                0,
                1);
    }
}
