/*
 * Copyright 2018 the original author.
 *
 * Daily Trade Reporting API is build for interview @JPMorgan.
 *
 */
package co.uk.jp.trading.strategy.weekendstrategy;

import java.time.LocalDate;

public interface IWeekendHandlerStrategy {

   /**
     * Returns working day if passed date {@link LocalDate} falls on Weekend
     * otherwise it will return same date.
     *
     * @param date {@link LocalDate}
     * @return LocalDate {@link LocalDate}
     */
    LocalDate getWorkingDay(LocalDate date) ;

}
