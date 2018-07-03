/*
 * Copyright 2018 the original author.
 *
 * Daily Trade Reporting API is build for interview @JPMorgan.
 *
 */
package co.uk.jp.trading.strategy.weekendstrategy.impl;

import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;

import co.uk.jp.trading.strategy.weekendstrategy.WeekendHandlerStrategy;

/**
 * This class is default strategy for countries where weekend is on SATURDAY n SUNDAY
 */

public class DefaultWeekendHandlerStrategy extends WeekendHandlerStrategy {

    private static DefaultWeekendHandlerStrategy instance = null;

    private DefaultWeekendHandlerStrategy() {
        super();
    }
    public static DefaultWeekendHandlerStrategy getInstance() {
        if (instance == null) {
            instance = new DefaultWeekendHandlerStrategy();
        }
        return instance;
    }
    @Override protected void setUpWeekendDays() {
        weekendDaysList.add(SATURDAY);
        weekendDaysList.add(SUNDAY);
    }
}
