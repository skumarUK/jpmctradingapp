/*
 * Copyright 2018 the original author.
 *
 * Daily Trade Reporting API is build for interview @JPMorgan.
 *
 */
package co.uk.jp.trading.strategy.reportingstrategy;

import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

import co.uk.jp.trading.model.Instruction;
public abstract class ReportGenerator implements IReportGenerator {

    protected abstract StringBuilder getReportHeader();

    protected abstract Predicate<Instruction> getInstructionsPredicate();

    protected abstract Map<?,?> getReportInstructions(Set<Instruction> instructions);

    protected abstract StringBuilder getReportContent(Map<?,?> reportData);

    @Override public StringBuilder generateReport(Set<Instruction> instructions) {
        Map<?,?> reportData = getReportInstructions(instructions);
        return getReportContent(reportData);
    }
}
