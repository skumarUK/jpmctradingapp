/*
 * Copyright 2018 the original author.
 *
 * Daily Trade Reporting API is build for interview @JPMorgan.
 *
 */
package co.uk.jp.trading.service.settlement;

import java.util.Set;

import co.uk.jp.trading.model.Instruction;

public interface ISettlementService {

    /**
     * This method does check if settlement date falls on weekend. Then it look for next working date
     * as per currency settlement strategy and set new settlement date.
     *
     * @param instructions  Set<Instructions> {@link java.util.List}
     */
     void checkAndUpdateSettlementDates(Set<Instruction> instructions);

    /**
     * This method does check if settlement date falls on weekend. Then it look for next working date
     * as per currency settlement strategy and set new settlement date.
     *
     * @param instruction  Instructions {@link Instruction}
     */
     void checkAndUpdateSettlementDate(Instruction instruction);
}
