package org.interview.task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TimerTask;

import org.interview.model.Clockin;
import org.interview.util.TransmitterUtil;

public class ScheduleTask extends TimerTask {

    @Override
    public void run() {
        try {
            for (Clockin clockin : createClockins()) {
                TransmitterUtil.sendEmployee(clockin.toJSON());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected List<Clockin> createClockins() {

        List<Clockin> clockins = new ArrayList<>();
        for (int i = 0; i < random.nextInt(10) + 1; i++) {
            clockins.add(createClockin());
        }
        return clockins;
    }

    protected Clockin createClockin() {
        LocalDateTime dateTime = LocalDateTime.of(LocalDate.now(), LocalTime
            .of(random.nextInt(24), random.nextInt(60), random.nextInt(60)));

        return new Clockin(pisArray[random.nextInt(10)], dateTime);
    }

    protected Random random = new Random();

    protected static final String[] pisArray = { "12083924837", "12055473249",
        "12031314892", "12089294380", "12063955842", "12007412855",
        "12073641352", "12081175233", "12061634640", "12063168140" };
}