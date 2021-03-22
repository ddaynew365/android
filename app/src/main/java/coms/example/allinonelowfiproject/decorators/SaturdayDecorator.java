package coms.example.allinonelowfiproject.decorators;

import android.graphics.Color;
import android.text.style.ForegroundColorSpan;

import coms.example.allinonelowfiproject.mainCalendar.CalendarDay;
import coms.example.allinonelowfiproject.mainCalendar.DayViewDecorator;
import coms.example.allinonelowfiproject.mainCalendar.DayViewFacade;

import java.util.Calendar;

public class SaturdayDecorator implements DayViewDecorator {
    private final Calendar calendar = Calendar.getInstance();

    public SaturdayDecorator() {
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
        return weekDay == Calendar.SATURDAY;
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.addSpan(new ForegroundColorSpan(Color.BLUE));
    }
}