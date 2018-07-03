/*
 * Copyright 2018 the original author.
 *
 * Daily Trade Reporting API is build for interview @JPMorgan.
 *
 */
package co.uk.jp.trading.strategy.reportingstrategy.amountsettlement;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.reducing;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

import co.uk.jp.trading.model.Instruction;
import co.uk.jp.trading.strategy.reportingstrategy.ReportGenerator;

public abstract class AmountSettlementReport extends ReportGenerator {

    /**
     * Calculates the daily incoming (SELL) trade amount in USD
     * @param instructions the instruction to calculate the stats from
     * @return a map from date to total amount
     */
    private Map<LocalDate, BigDecimal> calculateDailyAmount(
        Set<Instruction> instructions, Predicate<Instruction> predicate)
    {
        return instructions.stream()
            .filter(predicate)
            .collect(groupingBy(Instruction::getSettlementDate,
                mapping(Instruction::getTradeAmount,
                    reducing(BigDecimal.ZERO, BigDecimal::add))));
    }

    @Override public Map<LocalDate, BigDecimal> getReportInstructions(Set<Instruction> instructions) {
        return calculateDailyAmount(instructions,getInstructionsPredicate());
    }

    @Override protected StringBuilder getReportContent(Map <?, ?> reportData) {
        StringBuilder reportContent = new StringBuilder();
        reportContent.append(getReportHeader());
        reportContent.append(getReportBody(reportData));
        return reportContent;
    }

    private StringBuilder getReportBody(Map<?, ?> reportData) {
        StringBuilder reportContent = new StringBuilder();
        reportData.forEach((k,v)->reportContent
            .append(k).append("       |      ").append(v).append("\n"));
        return reportContent;
    }
}
