package coms.example.allinonelowfiproject.mainCalendar;

public enum CalendarMode {

    /**
     * Month Mode to display an entire month per page.
     */
    MONTHS(6),
    /**
     * Week mode that shows the calendar week by week.
     */
    WEEKS(1);

    /**
     * Number of visible weeks per calendar mode.
     */
    final int visibleWeeksCount;

    CalendarMode(int visibleWeeksCount) {
        this.visibleWeeksCount = visibleWeeksCount;
    }
}