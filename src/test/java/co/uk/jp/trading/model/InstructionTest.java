/*
 * Copyright 2018 the original author.
 *
 * Daily Trade Reporting API is build for interview @JPMorgan.
 *
 */
package co.uk.jp.trading.model;

import static org.junit.Assert.assertEquals;
import static utils.TestUtils.INSTRUCTION_INCOMING;
import static utils.TestUtils.INSTRUCTION_OUTGOING;

import java.math.BigDecimal;

import org.junit.Test;

public class InstructionTest {

    @Test
    public void Given_An_Outgoing_Instruction_Then_TradeAmount_Calculated() {
        final BigDecimal agreedFx = BigDecimal.valueOf(3.70);
        final BigDecimal pricePerUnit = BigDecimal.valueOf(105.25);
        final int units = 100;

        /*Price per unit * Units * Agreed Fx*/
        final BigDecimal tradeAmountExpected = pricePerUnit
            .multiply(BigDecimal.valueOf(units))
            .multiply(agreedFx)
            .setScale(2, BigDecimal.ROUND_HALF_EVEN);
        Instruction instruction = INSTRUCTION_OUTGOING;
        assertEquals(agreedFx, instruction.getAgreedFx());
        assertEquals(pricePerUnit, instruction.getPricePerUnit());
        assertEquals(units, instruction.getUnits());
        assertEquals(tradeAmountExpected, instruction.getTradeAmount());
    }

    @Test
    public void Given_An_Incoming_Instruction_Then_TradeAmount_Calculated() {
        final BigDecimal agreedFx = BigDecimal.valueOf(0.50);
        final BigDecimal pricePerUnit = BigDecimal.valueOf(97.25);
        final int units = 200;

        /*Price per unit * Units * Agreed Fx*/
        final BigDecimal tradeAmountExpected = pricePerUnit
            .multiply(BigDecimal.valueOf(units))
            .multiply(agreedFx)
            .setScale(2, BigDecimal.ROUND_HALF_EVEN);
        Instruction instruction = INSTRUCTION_INCOMING;
        assertEquals(agreedFx, instruction.getAgreedFx());
        assertEquals(pricePerUnit, instruction.getPricePerUnit());
        assertEquals(units, instruction.getUnits());
        assertEquals(tradeAmountExpected, instruction.getTradeAmount());
    }
}
