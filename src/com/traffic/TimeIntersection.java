package com.traffic;

import java.util.Timer;
import java.util.TimerTask;

public class TimeIntersection extends Intersection {

    public TimeIntersection(int x, int y, int secs[]) {
        super(x,y);
        Timer t = new Timer();

        t.scheduleAtFixedRate(
                new TimerTask()
                {
                    public void run()
                    {
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
