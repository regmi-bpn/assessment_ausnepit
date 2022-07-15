package com.assignment.four;

import java.util.Timer;
import java.util.TimerTask;

public class Messenger {

    private static final long INTERVAL_MILLI = 2 * 60 * 1000;
    private static final String MESSAGE = "HELLO";

    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println(MESSAGE);
            }
        };
        timer.scheduleAtFixedRate(task, 100, INTERVAL_MILLI);
    }
}
