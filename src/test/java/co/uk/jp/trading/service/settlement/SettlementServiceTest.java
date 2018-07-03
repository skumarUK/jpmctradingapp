/*
 * Copyright 2018 the original author.
 *
 * Daily Trade Reporting API is build for interview @JPMorgan.
 *
 */
package co.uk.jp.trading.service.settlement;
import static org.junit.Assert.assertEquals;
import static utils.TestUtils.DAY_FRIDAY;
import static utils.TestUtils.DAY_MONDAY;
import static utils.TestUtils.DAY_SUNDAY;
import static utils.TestUtils.DAY_THURSDAY;
import static utils.TestUtils.DAY_TUESDAY;
import static utils.TestUtils.DAY_WEDNESDAY;
import static utils.TestUtils.INSTRUCTION_AED_WHERE_SETTLEMENT_DATE_IS_FRIDAY;
import static utils.TestUtils.INSTRUCTION_AED_WHERE_SETTLEMENT_DATE_IS_SATURDAY;
import static utils.TestUtils.INSTRUCTION_AED_WHERE_SETTLEMENT_DATE_IS_SUNDAY;
import static utils.TestUtils.INSTRUCTION_AUD_WHERE_SETTLEMENT_DATE_IS_TUESDAY;
import static utils.TestUtils.INSTRUCTION_GBP_WHERE_SETTLEMENT_DATE_IS_WEDNESDAY;
import static utils.TestUtils.INSTRUCTION_INR_WHERE_SETTLEMENT_DATE_IS_THURSDAY;
import static utils.TestUtils.INSTRUCTION_NZD_WHERE_SETTLEMENT_DATE_IS_FRIDAY;
import static utils.TestUtils.INSTRUCTION_SAR_WHERE_SETTLEMENT_DATE_IS_FRIDAY;
import static utils.TestUtils.INSTRUCTION_SAR_WHERE_SETTLEMENT_DATE_IS_SATURDAY;
import static utils.TestUtils.INSTRUCTION_SAR_WHERE_SETTLEMENT_DATE_IS_SUNDAY;
import static utils.TestUtils.INSTRUCTION_SGD_WHERE_SETTLEMENT_DATE_IS_MONDAY;
import static utils.TestUtils.INSTRUCTION_SGD_WHERE_SETTLEMENT_DATE_IS_SUNDAY;
import static utils.TestUtils.INSTRUCTION_USD_WHERE_SETTLEMENT_DATE_IS_SATURDAY;
import static utils.TestUtils.getInstructionsForMixedSettlementDateAndCurrencies;

import java.util.Iterator;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import co.uk.jp.trading.model.Instruction;
import co.uk.jp.trading.service.settlement.impl.SettlementServiceImpl;

public class SettlementServiceTest {

    private ISettlementService settlementService;

    @Before
    public void setUp(){
        settlementService = new SettlementServiceImpl();
    }

    @Test
    public void when_GivenSettlementDate_Is_WeekDay_Then_No_Change(){
        settlementService.checkAndUpdateSettlementDate(INSTRUCTION_SGD_WHERE_SETTLEMENT_DATE_IS_MONDAY);
        assertEquals(DAY_MONDAY,INSTRUCTION_SGD_WHERE_SETTLEMENT_DATE_IS_MONDAY.getSettlementDate());
        settlementService.checkAndUpdateSettlementDate(INSTRUCTION_AUD_WHERE_SETTLEMENT_DATE_IS_TUESDAY);
        assertEquals(DAY_TUESDAY,INSTRUCTION_AUD_WHERE_SETTLEMENT_DATE_IS_TUESDAY.getSettlementDate());
        settlementService.checkAndUpdateSettlementDate(INSTRUCTION_GBP_WHERE_SETTLEMENT_DATE_IS_WEDNESDAY);
        assertEquals(DAY_WEDNESDAY,INSTRUCTION_GBP_WHERE_SETTLEMENT_DATE_IS_WEDNESDAY.getSettlementDate());
        settlementService.checkAndUpdateSettlementDate(INSTRUCTION_INR_WHERE_SETTLEMENT_DATE_IS_THURSDAY);
        assertEquals(DAY_THURSDAY, INSTRUCTION_INR_WHERE_SETTLEMENT_DATE_IS_THURSDAY.getSettlementDate());
        settlementService.checkAndUpdateSettlementDate(INSTRUCTION_NZD_WHERE_SETTLEMENT_DATE_IS_FRIDAY);
        assertEquals(DAY_FRIDAY,INSTRUCTION_NZD_WHERE_SETTLEMENT_DATE_IS_FRIDAY.getSettlementDate());

        /*SUNDAY is working day in countries where currency is SAR or AED*/
        settlementService.checkAndUpdateSettlementDate(INSTRUCTION_SAR_WHERE_SETTLEMENT_DATE_IS_SUNDAY);
        assertEquals(DAY_SUNDAY,INSTRUCTION_SAR_WHERE_SETTLEMENT_DATE_IS_SUNDAY.getSettlementDate());
        settlementService.checkAndUpdateSettlementDate(INSTRUCTION_AED_WHERE_SETTLEMENT_DATE_IS_SUNDAY);
        assertEquals(DAY_SUNDAY,INSTRUCTION_AED_WHERE_SETTLEMENT_DATE_IS_SUNDAY.getSettlementDate());

    }

    @Test
    public void when_GivenSettlementDate_Is_WeekEnd_Then_Next_WorkingDay(){
        settlementService.checkAndUpdateSettlementDate(INSTRUCTION_USD_WHERE_SETTLEMENT_DATE_IS_SATURDAY);
        assertEquals(DAY_MONDAY,INSTRUCTION_USD_WHERE_SETTLEMENT_DATE_IS_SATURDAY.getSettlementDate());
        settlementService.checkAndUpdateSettlementDate(INSTRUCTION_SGD_WHERE_SETTLEMENT_DATE_IS_SUNDAY);
        assertEquals(DAY_MONDAY,INSTRUCTION_SGD_WHERE_SETTLEMENT_DATE_IS_SUNDAY.getSettlementDate());
        /*SUNDAY is working day in countries where currency is SAR or AED*/
        settlementService.checkAndUpdateSettlementDate(INSTRUCTION_AED_WHERE_SETTLEMENT_DATE_IS_FRIDAY);
        /*Friday is weekend day in countries where currency is SAR or AED*/
        assertEquals(DAY_SUNDAY,INSTRUCTION_AED_WHERE_SETTLEMENT_DATE_IS_FRIDAY.getSettlementDate());
        settlementService.checkAndUpdateSettlementDate(INSTRUCTION_AED_WHERE_SETTLEMENT_DATE_IS_SATURDAY);
        assertEquals(DAY_SUNDAY,INSTRUCTION_AED_WHERE_SETTLEMENT_DATE_IS_SATURDAY.getSettlementDate());
        settlementService.checkAndUpdateSettlementDate(INSTRUCTION_SAR_WHERE_SETTLEMENT_DATE_IS_FRIDAY);
        assertEquals(DAY_SUNDAY,INSTRUCTION_SAR_WHERE_SETTLEMENT_DATE_IS_FRIDAY.getSettlementDate());
        settlementService.checkAndUpdateSettlementDate(INSTRUCTION_SAR_WHERE_SETTLEMENT_DATE_IS_SATURDAY);
        assertEquals(DAY_SUNDAY,INSTRUCTION_SAR_WHERE_SETTLEMENT_DATE_IS_SATURDAY.getSettlementDate());
    }

    @Test
    public void when_Given_MultipleInstructions_With_Mix_SettlementDate_Then_Only_Weekend_One_Changed_to_Next_WorkingDay(){
        Set<Instruction> instructions = getInstructionsForMixedSettlementDateAndCurrencies();
        settlementService.checkAndUpdateSettlementDates(instructions);
        Iterator<Instruction> iterator = instructions.iterator();
        assertEquals(DAY_MONDAY,iterator.next().getSettlementDate());
        assertEquals(DAY_SUNDAY,iterator.next().getSettlementDate());
    }
}
