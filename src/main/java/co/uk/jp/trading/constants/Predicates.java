/*
 * Copyright 2018 the original author.
 *
 * Daily Trade Reporting API is build for interview @JPMorgan.
 *
 */
package co.uk.jp.trading.constants;

import java.util.function.Predicate;

import co.uk.jp.trading.model.Instruction;


public class Predicates {

    /**
     * B – Buy – outgoing
     */
    public final static Predicate<Instruction> OUTGOING_INSTRUCTIONS_PREDICATE =
        instruction -> instruction.getAction().equals(TradingAction.BUY);

    /**
     * S – Sell – incoming
     */
    public final static Predicate<Instruction> INCOMING_INSTRUCTIONS_PREDICATE  =
        instruction -> instruction.getAction().equals(TradingAction.SELL);
}
