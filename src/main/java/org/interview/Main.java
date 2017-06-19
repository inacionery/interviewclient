package org.interview;

import java.util.Timer;

import org.interview.task.ScheduleTask;

public class Main {
    public static void main(String args[]) {
        Timer time = new Timer();

        time.schedule(new ScheduleTask(), 0, 1000 * 60 * 05);
    }
}
