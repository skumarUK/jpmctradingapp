/*
 * Copyright 2018 the original author.
 *
 * Daily Trade Reporting API is build for interview @JPMorgan.
 *
 */
package co.uk.jp.trading.strategy.weekendstrategy;

import static junit.framework.TestCase.assertTrue;

import java.util.Currency;

import org.junit.Test;

import co.uk.jp.trading.constants.Currencies;
import co.uk.jp.trading.strategy.weekendstrategy.impl.DefaultWeekendHandlerStrategy;
import co.uk.jp.trading.strategy.weekendstrategy.impl.FriNSatWeekendHandlerStrategy;

public class WeekendHandlerStrategyFactoryTest {

    private IWeekendHandlerStrategy weekendHandlerStrategy;

    @Test
    public void when_GivenCurrency_Is_AED_Then_FriNSatWeekendHandlerStrategy(){
        weekendHandlerStrategy = WeekendStrategyFactory.getWeekendStrategyInstance(Currency.getInstance(Currencies.AED_ISO_CODE));
        assertTrue(weekendHandlerStrategy instanceof FriNSatWeekendHandlerStrategy);
    }

    @Test
    public void when_GivenCurrency_Is_SAR_Then_FriNSatWeekendHandlerStrategy(){
        weekendHandlerStrategy = WeekendStrategyFactory.getWeekendStrategyInstance(Currency.getInstance(Currencies.SAR_ISO_CODE));
        assertTrue(weekendHandlerStrategy instanceof FriNSatWeekendHandlerStrategy);
    }

    @Test
    public void when_GivenCurrency_Is_NOT_AED_OR_SAR_Then_DefaultWeekendHandlerStrategy(){
        weekendHandlerStrategy = WeekendStrategyFactory.getWeekendStrategyInstance(Currency.getInstance("USD"));
        assertTrue(weekendHandlerStrategy instanceof DefaultWeekendHandlerStrategy);
    }

    @Test
    public void when_GivenCurrency_Is_NULL_Then_DefaultWeekendHandlerStrategy(){
        weekendHandlerStrategy = WeekendStrategyFactory.getWeekendStrategyInstance(null);
        assertTrue(weekendHandlerStrategy instanceof DefaultWeekendHandlerStrategy);
    }
}
