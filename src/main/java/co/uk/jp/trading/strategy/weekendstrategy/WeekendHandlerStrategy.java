/*
 * Copyright 2018 the original author.
 *
 * Daily Trade Reporting API is build for interview @JPMorgan.
 *
 */
package co.uk.jp.trading.strategy.weekendstrategy;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
* This class is abstract implementation of IWeekendHandlerStrategy
* which is further extended by respective handler Implementation.
*
 */

public abstract class WeekendHandlerStrategy implements IWeekendHandlerStrategy {

    protected List<DayOfWeek> weekendDaysList = new ArrayList<>();

    protected abstract void setUpWeekendDays();

    /**
     * This method checks whether day of the date passed is a Weekend day. If No it return same date, otherwise
     * it increments and calls this method to check for next day.
     * @param date {@link LocalDate}
     * @return LocalDate {@link LocalDate}
     *
     */
    @Override
    public LocalDate getWorkingDay(LocalDate date) {
        setUpWeekendDays();
        if(!weekendDaysList.stream().
            anyMatch(dayOfWeek ->
                dayOfWeek.compareTo(date.getDayOfWeek())==0)){
            return date;
        }else {
            return getWorkingDay(date.plusDays(1));
        }
    }
}
