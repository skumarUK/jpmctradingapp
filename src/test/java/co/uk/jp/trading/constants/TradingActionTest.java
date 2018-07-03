/*
 * Copyright 2018 the original author.
 *
 * Daily Trade Reporting API is build for interview @JPMorgan.
 *
 */
package co.uk.jp.trading.constants;

import static org.junit.Assert.assertEquals;

import java.util.NoSuchElementException;

import org.junit.Test;

public class TradingActionTest {

    @Test
    public void Given_An_Outgoing_InstructionType_Then_TradeAction_BUY() {
        String instructionType ="B";
        assertEquals(TradingAction.BUY, TradingAction.getByValue(instructionType));
    }

    @Test
    public void Given_An_Incoming_InstructionType_Then_TradeAction_SELL() {
        String instructionType ="S";
        assertEquals(TradingAction.SELL, TradingAction.getByValue(instructionType));
    }

    @Test(expected = NoSuchElementException.class)
    public void Given_A_NULL_InstructionType_Then_() {
        TradingAction.getByValue(null);
    }
}
