/*
 * Copyright 2018 the original author.
 *
 * Daily Trade Reporting API is build for interview @JPMorgan.
 *
 */
package co.uk.jp.trading.strategy.weekendstrategy.impl;

import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.SATURDAY;

import co.uk.jp.trading.strategy.weekendstrategy.WeekendHandlerStrategy;

/**
 * This class is strategy for the countries where weekend is on FRIDAY n SATURDAY
 * i.e. United Arab Emirates
 *  Saudi Arabia
 *  Iraq
 *  Israel
 */

public class FriNSatWeekendHandlerStrategy extends WeekendHandlerStrategy {

    private static FriNSatWeekendHandlerStrategy instance = null;

    private FriNSatWeekendHandlerStrategy() {
        super();
    }
    public static FriNSatWeekendHandlerStrategy getInstance() {
        if (instance == null) {
            instance = new FriNSatWeekendHandlerStrategy();
        }
        return instance;
    }
    /**
     * As per strategy this method adds Friday and Saturday DayOfWeek
     * to the WeekendDaysList.
     *
     */
    @Override protected void  setUpWeekendDays() {
        weekendDaysList.add(FRIDAY);
        weekendDaysList.add(SATURDAY);
    }
}
