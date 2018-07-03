/*
 * Copyright 2018 the original author.
 *
 * Daily Trade Reporting API is build for interview @JPMorgan.
 *
 */
package co.uk.jp.trading.strategy.weekendstrategy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static utils.TestUtils.DAY_FRIDAY;
import static utils.TestUtils.DAY_MONDAY;
import static utils.TestUtils.DAY_SATURDAY;
import static utils.TestUtils.DAY_SUNDAY;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import co.uk.jp.trading.strategy.weekendstrategy.impl.FriNSatWeekendHandlerStrategy;

public class FriNSatWeekendHandlerStrategyTest {

    private IWeekendHandlerStrategy weekendHandlerStrategy;

    @Before
    public void setUp(){
        weekendHandlerStrategy = FriNSatWeekendHandlerStrategy.getInstance();
    }

    @Test
    public void when_GivenDate_Is_WeekDay_Then_WorkingDay_Is_Same(){
        final LocalDate aSunday = DAY_SUNDAY;
        assertEquals(aSunday, weekendHandlerStrategy.getWorkingDay(aSunday));
        assertNotEquals(DAY_MONDAY, weekendHandlerStrategy.getWorkingDay(aSunday));
    }

    @Test
    public void when_GivenDate_Is_Friday_Then_WorkingDay_Is_Sunday(){
        final LocalDate aFriday = DAY_FRIDAY;
        assertNotEquals(aFriday, weekendHandlerStrategy.getWorkingDay(aFriday));
        assertEquals(DAY_SUNDAY, weekendHandlerStrategy.getWorkingDay(aFriday));
    }

    @Test
    public void when_GivenDate_Is_Saturday_Then_WorkingDay_Is_Sunday(){
        final LocalDate aSaturday = DAY_SATURDAY;
        assertNotEquals(aSaturday, weekendHandlerStrategy.getWorkingDay(aSaturday));
        assertEquals(DAY_SUNDAY, weekendHandlerStrategy.getWorkingDay(aSaturday));
    }


}
