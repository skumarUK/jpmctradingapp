package utils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;
import java.util.LinkedHashSet;
import java.util.Set;

import co.uk.jp.trading.constants.TradingAction;
import co.uk.jp.trading.model.Instruction;
import co.uk.jp.trading.model.TradingDetails;

public class TestUtils {
    public static final LocalDate DAY_TUESDAY = LocalDate.of(2018, 6, 19);
    public static final LocalDate DAY_WEDNESDAY = LocalDate.of(2018, 6, 20);
    public static final LocalDate DAY_THURSDAY = LocalDate.of(2018, 6, 21);
    public static final LocalDate DAY_FRIDAY = LocalDate.of(2018, 6, 22);
    public static final LocalDate DAY_SATURDAY = LocalDate.of(2018, 6, 23);
    public static final LocalDate DAY_SUNDAY = LocalDate.of(2018, 6, 24);
    public static final LocalDate DAY_MONDAY = LocalDate.of(2018, 6, 25);



    public static final Instruction INSTRUCTION_SGD_WHERE_SETTLEMENT_DATE_IS_MONDAY = new Instruction(
        "E1",
        TradingAction.SELL,
        LocalDate.of(2017, 3, 10),
        DAY_MONDAY,
        new TradingDetails(
            Currency.getInstance("SGD"),
            BigDecimal.valueOf(0.50),
            200,
            BigDecimal.valueOf(100.25)));

    public static final Instruction INSTRUCTION_AUD_WHERE_SETTLEMENT_DATE_IS_TUESDAY= new Instruction(
        "E2",
        TradingAction.BUY,
        LocalDate.of(2017, 3, 10),
        DAY_TUESDAY,
        new TradingDetails(
            Currency.getInstance("AUD"),
            BigDecimal.valueOf(0.70),
            200,
            BigDecimal.valueOf(102.25)));

    public static final Instruction INSTRUCTION_GBP_WHERE_SETTLEMENT_DATE_IS_WEDNESDAY= new Instruction(
        "E3",
        TradingAction.BUY,
        LocalDate.of(2017, 3, 10),
        DAY_WEDNESDAY,
        new TradingDetails(
            Currency.getInstance("GBP"),
            BigDecimal.valueOf(0.30),
            200,
            BigDecimal.valueOf(103.25)));

    public static final Instruction INSTRUCTION_INR_WHERE_SETTLEMENT_DATE_IS_THURSDAY = new Instruction(
        "E4",
        TradingAction.BUY,
        LocalDate.of(2017, 3, 10),
        DAY_THURSDAY,
        new TradingDetails(
            Currency.getInstance("SGD"),
            BigDecimal.valueOf(0.50),
            150,
            BigDecimal.valueOf(100.25)));

    public static final Instruction INSTRUCTION_NZD_WHERE_SETTLEMENT_DATE_IS_FRIDAY= new Instruction(
        "E1",
        TradingAction.BUY,
        LocalDate.of(2017, 3, 10),
        DAY_FRIDAY,
        new TradingDetails(
            Currency.getInstance("NZD"),
            BigDecimal.valueOf(0.50),
            100,
            BigDecimal.valueOf(100.25)));

    public static final Instruction INSTRUCTION_USD_WHERE_SETTLEMENT_DATE_IS_SATURDAY = new Instruction(
        "E5",
        TradingAction.BUY,
        LocalDate.of(2017, 3, 10),
        DAY_SATURDAY,
        new TradingDetails(
            Currency.getInstance("USD"),
            BigDecimal.valueOf(0.50),
            200,
            BigDecimal.valueOf(100.25)));

    public static final Instruction INSTRUCTION_SGD_WHERE_SETTLEMENT_DATE_IS_SUNDAY = new Instruction(
        "E7",
        TradingAction.BUY,
        LocalDate.of(2017, 3, 10),
        DAY_SUNDAY,
        new TradingDetails(
            Currency.getInstance("SGD"),
            BigDecimal.valueOf(0.50),
            200,
            BigDecimal.valueOf(100.25)));

    public static final Instruction INSTRUCTION_AED_WHERE_SETTLEMENT_DATE_IS_SUNDAY = new Instruction(
        "E7",
        TradingAction.BUY,
        LocalDate.of(2017, 3, 10),
        DAY_SUNDAY,
        new TradingDetails(
            Currency.getInstance("AED"),
            BigDecimal.valueOf(0.50),
            200,
            BigDecimal.valueOf(100.25)));

    public static final Instruction INSTRUCTION_SAR_WHERE_SETTLEMENT_DATE_IS_SUNDAY = new Instruction(
        "E11",
        TradingAction.BUY,
        LocalDate.of(2017, 3, 10),
        DAY_SUNDAY,
        new TradingDetails(
            Currency.getInstance("SAR"),
            BigDecimal.valueOf(0.50),
            500,
            BigDecimal.valueOf(100.25)));

    public static final Instruction INSTRUCTION_AED_WHERE_SETTLEMENT_DATE_IS_FRIDAY = new Instruction(
        "E8",
        TradingAction.BUY,
        LocalDate.of(2017, 3, 10),
        DAY_FRIDAY,
        new TradingDetails(
            Currency.getInstance("AED"),
            BigDecimal.valueOf(0.50),
            200,
            BigDecimal.valueOf(100.25)));

    public static final Instruction INSTRUCTION_AED_WHERE_SETTLEMENT_DATE_IS_SATURDAY = new Instruction(
        "E8",
        TradingAction.BUY,
        LocalDate.of(2017, 3, 10),
        DAY_SATURDAY,
        new TradingDetails(
            Currency.getInstance("AED"),
            BigDecimal.valueOf(0.50),
            200,
            BigDecimal.valueOf(100.25)));

    public static final Instruction INSTRUCTION_SAR_WHERE_SETTLEMENT_DATE_IS_FRIDAY = new Instruction(
        "E9",
        TradingAction.BUY,
        LocalDate.of(2017, 3, 10),
        DAY_FRIDAY,
        new TradingDetails(
            Currency.getInstance("SAR"),
            BigDecimal.valueOf(0.50),
            170,
            BigDecimal.valueOf(100.25)));

    public static final Instruction INSTRUCTION_SAR_WHERE_SETTLEMENT_DATE_IS_SATURDAY = new Instruction(
        "E10",
        TradingAction.SELL,
        LocalDate.of(2017, 3, 10),
        DAY_SATURDAY,
        new TradingDetails(
            Currency.getInstance("SAR"),
            BigDecimal.valueOf(0.50),
            150,
            BigDecimal.valueOf(100.25)));

    public static final Instruction INSTRUCTION_OUTGOING_TUESDAY = new Instruction(
        "E12",
        TradingAction.BUY,
        LocalDate.of(2017, 3, 10),
        DAY_TUESDAY,
        new TradingDetails(
            Currency.getInstance("AUD"),
            BigDecimal.valueOf(0.70),
            200,
            BigDecimal.valueOf(105.25)));

    public static final Instruction INSTRUCTION_OUTGOING_TUESDAY_1 = new Instruction(
        "E12",
        TradingAction.BUY,
        LocalDate.of(2017, 3, 10),
        DAY_TUESDAY,
        new TradingDetails(
            Currency.getInstance("AUD"),
            BigDecimal.valueOf(0.70),
            150,
            BigDecimal.valueOf(105.25)));

    public static final Instruction INSTRUCTION_OUTGOING_TUESDAY_2 = new Instruction(
        "E12",
        TradingAction.BUY,
        LocalDate.of(2017, 3, 10),
        DAY_TUESDAY,
        new TradingDetails(
            Currency.getInstance("AUD"),
            BigDecimal.valueOf(0.70),
            150,
            BigDecimal.valueOf(105.25)));
    public static final Instruction INSTRUCTION_OUTGOING = new Instruction(
        "E1001",
        TradingAction.BUY,
        LocalDate.of(2017, 3, 10),
        DAY_TUESDAY,
        new TradingDetails(
            Currency.getInstance("MYR"),
            BigDecimal.valueOf(3.70),
            100,
            BigDecimal.valueOf(105.25)));
    public static final Instruction INSTRUCTION_INCOMING = new Instruction(
        "E1002",
        TradingAction.SELL,
        LocalDate.of(2017, 3, 10),
        DAY_TUESDAY,
        new TradingDetails(
            Currency.getInstance("JPY"),
            BigDecimal.valueOf(0.50),
            200,
            BigDecimal.valueOf(97.25)));
    public static Set<Instruction> instructions;
    public static Set<Instruction> getIncomingInstructionsDifferentSettlementDate(){
        instructions = new LinkedHashSet <>();
        instructions.add(INSTRUCTION_SGD_WHERE_SETTLEMENT_DATE_IS_MONDAY);
        instructions.add(INSTRUCTION_SAR_WHERE_SETTLEMENT_DATE_IS_SATURDAY);
        return instructions;
    }

    public static Set<Instruction> getOutgoingInstructionsSameSettlementDate(){
        instructions = new LinkedHashSet <>();
        instructions.add(INSTRUCTION_AUD_WHERE_SETTLEMENT_DATE_IS_TUESDAY);
        instructions.add(INSTRUCTION_OUTGOING_TUESDAY);
        return instructions;
    }

    public static Set<Instruction> getOutgoingInstructionsSameSettlementDateSameEntityMultipleTimes(){
        instructions = new LinkedHashSet <>();
        instructions.add(INSTRUCTION_AUD_WHERE_SETTLEMENT_DATE_IS_TUESDAY);
        instructions.add(INSTRUCTION_OUTGOING_TUESDAY);
        instructions.add(INSTRUCTION_OUTGOING_TUESDAY_1);
        instructions.add(INSTRUCTION_OUTGOING_TUESDAY_2);
        return instructions;
    }

    public static Set<Instruction> getInstructionsForMixedSettlementDateAndCurrencies(){
        instructions = new LinkedHashSet <>();
        instructions.add(INSTRUCTION_SGD_WHERE_SETTLEMENT_DATE_IS_SUNDAY);
        instructions.add(INSTRUCTION_AED_WHERE_SETTLEMENT_DATE_IS_SUNDAY);
        return instructions;
    }
}
