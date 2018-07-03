/*
 * Copyright 2018 the original author.
 *
 * Daily Trade Reporting API is build for interview @JPMorgan.
 *
 */
package co.uk.jp.trading.strategy.weekendstrategy;

import static co.uk.jp.trading.constants.Currencies.AED_ISO_CODE;
import static co.uk.jp.trading.constants.Currencies.SAR_ISO_CODE;

import java.util.Currency;

import co.uk.jp.trading.strategy.weekendstrategy.impl.DefaultWeekendHandlerStrategy;
import co.uk.jp.trading.strategy.weekendstrategy.impl.FriNSatWeekendHandlerStrategy;

/**
 * This is factory class to choose Weekend Handler Strategy based on Currency
 */

public class WeekendStrategyFactory {

    /**
     * Select WeekendHandler strategy based on the Currency.
     * If NULL currency is supplied it will return DefaultWeekendHandler Strategy.
     *
     * @param currency {@link Currency}
     * @return IWeekendHandlerStrategy {@link IWeekendHandlerStrategy}
     */
    public static IWeekendHandlerStrategy getWeekendStrategyInstance(Currency currency){

        if(currency==null){
            return DefaultWeekendHandlerStrategy.getInstance();
        }
        switch(currency.getCurrencyCode()){
            case AED_ISO_CODE :
            case SAR_ISO_CODE :
             return FriNSatWeekendHandlerStrategy.getInstance();
            default:
             return DefaultWeekendHandlerStrategy.getInstance();
        }
    }
}
