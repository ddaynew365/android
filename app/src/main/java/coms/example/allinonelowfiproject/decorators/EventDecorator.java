package coms.example.allinonelowfiproject.decorators;

import android.app.Activity;
import android.graphics.drawable.Drawable;

import androidx.fragment.app.Fragment;

import coms.example.allinonelowfiproject.R;
import coms.example.allinonelowfiproject.mainCalendar.CalendarDay;
import coms.example.allinonelowfiproject.mainCalendar.DayViewDecorator;
import coms.example.allinonelowfiproject.mainCalendar.DayViewFacade;

import java.util.Collection;
import java.util.HashSet;

public class EventDecorator implements DayViewDecorator {
    private final Drawable drawable;
    private int color;
    private HashSet<CalendarDay> dates;

    public EventDecorator(int color, Collection<CalendarDay> dates, Activity context) {
        drawable = context.getResources().getDrawable(R.drawable.more);
        this.color = color;
        this.dates = new HashSet<>(dates);
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        return dates.contains(day);
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.setSelectionDrawable(drawable);
        //view.addSpan(new DotSpan(5, color)); // 날자밑에 점
    }
}