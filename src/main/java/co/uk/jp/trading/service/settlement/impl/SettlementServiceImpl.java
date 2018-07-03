/*
 * Copyright 2018 the original author.
 *
 * Daily Trade Reporting API is build for interview @JPMorgan.
 *
 */
package co.uk.jp.trading.service.settlement.impl;

import java.util.Set;

import co.uk.jp.trading.model.Instruction;
import co.uk.jp.trading.service.settlement.ISettlementService;
import co.uk.jp.trading.strategy.weekendstrategy.IWeekendHandlerStrategy;
import co.uk.jp.trading.strategy.weekendstrategy.WeekendStrategyFactory;

public class SettlementServiceImpl implements ISettlementService {

    @Override public void checkAndUpdateSettlementDate(Instruction instruction){
        IWeekendHandlerStrategy weekendHandlerStrategy =
            WeekendStrategyFactory.getWeekendStrategyInstance(instruction.getCurrency());
        instruction.setSettlementDate(weekendHandlerStrategy.getWorkingDay(instruction.getSettlementDate()));
    }
    @Override public void checkAndUpdateSettlementDates(Set<Instruction> instructions) {
        instructions.forEach(this::checkAndUpdateSettlementDate);
    }
}
