package com.example.moodplus.date;
import java.util.Calendar;

public class DayMood {
    private String calendar;
    private int mood;

    public DayMood(
            String calendar, int mood
    ) {
        this.calendar = calendar;
        this.mood = mood;
    }

    public int getMood() {
        return mood;
    }

    public String getCalendar() {
        return calendar;
    }
}
